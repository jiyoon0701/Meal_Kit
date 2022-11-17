package controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

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

	@Autowired
	private ItemService service;

	// 상품 등록 페이지 이동
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String getcreate() throws Exception {
		return "admin/create";
	}

	// 게시물 작성 post
	@PostMapping("/create")
	public String postcreate(@ModelAttribute("item") Item item) throws IOException {

		// 파일 업로드
		String fileName = null;
		MultipartFile uploadFile = item.getUploadFile();
//	      System.out.println("너 누구냐?"+item.getUploadFile());
		System.out.println(item);
		if (uploadFile != null) {
			String originalFileName = uploadFile.getOriginalFilename();
			String ext = FilenameUtils.getExtension(originalFileName); // 확장자 구하기
			UUID uuid = UUID.randomUUID(); // UUID 구하기
			fileName = uuid + "." + ext;
			uploadFile.transferTo(
					new File("C:\\Users\\Yoon\\Documents\\GitHub\\Meal_Kit\\kickit\\src\\main\\webapp\\resource\\img\\"
							+ fileName));
		}
		item.setFile_name(fileName);

		// System.out.println(fileName);
		service.create(item);
		return "admin/create";
	}
	

	@GetMapping("main")
	public String getAdmin() {

		return "admin/main";
	}

	@GetMapping("accessDenied")
	public String AccessDenied() {
		return "admin/accessDenied";
	}

}
