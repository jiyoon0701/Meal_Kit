package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import org.json.simple.JSONObject;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import dto.Item;
import service.ItemService;
import org.springframework.web.bind.annotation.RequestParam;
import dto.Item;
import dto.ItemPurchase;
import service.ItemPurchaseService;
import service.ItemService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("admin")
public class AdminController {
	@Autowired
	private ItemService service;

	/*
	 * // 상품 등록 페이지 이동
	 * 
	 * @RequestMapping(value = "/create", method = RequestMethod.GET) public String
	 * getcreate() throws Exception { return "board/create"; }
	 */

	// 게시물 작성 post
	@PostMapping("/create")
	public String postcreate(@ModelAttribute("item") Item item, HttpServletRequest request, MultipartFile uploadFile,
		MultipartHttpServletRequest mtfRequest, HttpSession session) throws IllegalStateException, IOException {
		
		String pdfPath = request.getSession().getServletContext().getRealPath("/resources/img/");
		System.out.println(pdfPath+"path");
		// 단일
		
		List<MultipartFile> detailImgFileList = mtfRequest.getFiles("file");
		 if(detailImgFileList != null) {
	         String originalFileName = detailImgFileList.get(0).getOriginalFilename();
	         detailImgFileList.get(0).transferTo(new File(pdfPath +originalFileName ));
	         item.setFile_name(originalFileName);
	      }
		 
		service.create(item);
	     
		// 다중
		List<MultipartFile> detailImgFileLists = mtfRequest.getFiles("files");
		System.out.println(detailImgFileLists.size());
		ArrayList<String> arr = new ArrayList<String>();
		String fileName = null;
		int i;
		for(i=0; i<detailImgFileLists.size(); i++) {
			MultipartFile mf = detailImgFileLists.get(i);
			fileName = mf.getOriginalFilename();
			File detailFile = new File(pdfPath + fileName);
			try {
				mf.transferTo(detailFile);
				arr.add(fileName);
				
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		for(int j = i-1; j < 5; j++) {
			arr.add("null");
		}
				
		// map 다중으로 보내기
		service.insertPicture(arr);

		return "redirect:/admin/create";
	}

	@Autowired
	ItemService itemService;
	
	@Autowired
	ItemPurchaseService itemPurchaseService;
	
	@GetMapping("main")
	public String getAdmin(Model model) {
		System.out.println("start getAdmin Method");
		List<ItemPurchase> revenues = itemPurchaseService.getRevenue();
		List<Item> items = itemService.getItem();
		JSONObject quantities = new JSONObject();
		for(Item item : items) {
			quantities.put(item.getItem(),item.getQuantity());
		}
		int index = revenues.toString().indexOf("=");
		model.addAttribute("itemPurchaseList",revenues.toString().substring(index+1));
		model.addAttribute(items);
		model.addAttribute("quantities",quantities);
		System.out.println(model);
		return "admin/main";
	}
	
	@GetMapping("main/deleteItem")
	public String deleteItem(@RequestParam("itemCode") String itemCode) {
		System.out.println("start deleteItem Method");
		itemService.deleteItemByItemCode(itemCode);
		return "redirect:/admin/main";
	}

	@GetMapping("accessDenied")
	public String AccessDenied() {
		return "admin/accessDenied";
	}

}
