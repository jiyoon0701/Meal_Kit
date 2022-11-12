package controller;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import dto.Item;
import service.ItemService;
import java.security.Principal;
import java.util.Iterator;

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

import dto.User;
import service.UserService;

@Controller
@RequestMapping("admin")
public class AdminController {
	
	@Autowired
	private ItemService service;
	

	
	// 상품 등록 페이지 이동
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String getcreate() throws Exception {
		return "board/create";
	}
	
	// 게시물 작성 post
	@PostMapping("/create")
	public String postcreate(@ModelAttribute("item")Item item) throws IOException{
		
		// 파일 업로드
		String fileName=null;
		MultipartFile uploadFile = item.getUploadFile();
//		System.out.println("너 누구냐?"+item.getUploadFile());
		System.out.println(item);
		if(uploadFile != null) {
			String originalFileName = uploadFile.getOriginalFilename();
			String ext = FilenameUtils.getExtension(originalFileName);	//확장자 구하기
			UUID uuid = UUID.randomUUID();	//UUID 구하기
			fileName=uuid+"."+ext;
			uploadFile.transferTo(new File("C:\\Users\\Yoon\\Documents\\GitHub\\Meal_Kit\\kickit\\src\\main\\webapp\\resource\\img\\" + fileName));
		}
		item.setFileName(fileName);
		
		//System.out.println(fileName);
		service.create(item);
		return "board/create";
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

