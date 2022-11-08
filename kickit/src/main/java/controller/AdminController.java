package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dto.Item;
import service.ItemService;

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
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String postcreate(Item item) throws Exception{
		service.create(item);
		return "board/create";
	}
	
}