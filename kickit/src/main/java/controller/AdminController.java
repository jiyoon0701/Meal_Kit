package controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import dto.Item;
import dto.User;

import service.ItemService;

@Controller
@RequestMapping("admin")
public class AdminController {

	@Autowired
	private ItemService itemService;

	// 상품 등록 페이지 이동
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String getcreate() throws Exception {
		return "admin/create";
	}

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

			 itemService.create(item);

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
			itemService.insertPicture(arr);


			return "redirect:/admin/create";
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
