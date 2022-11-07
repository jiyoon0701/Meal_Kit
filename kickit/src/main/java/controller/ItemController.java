package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dto.Item;
import service.AdminService;

@Controller
@RequestMapping("content")
public class ItemController {
	
	@Autowired
	AdminService service;
	
	@RequestMapping("info")
	public ModelAndView info(Integer item) {
		ModelAndView mav = new ModelAndView();
		//item : id 에 해당하는 db 레코드 정보를 한개 저장 객체
		//Item items = service.(item);
		//mav.addObject("items",items); //item 객체에 "item" 이름 설정
		return mav;
		//return "item/info";
	}
}
