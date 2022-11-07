package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dto.Item;
import service.ItemService;

@Controller
@RequestMapping("content")
public class ItemController {

	@Autowired
	ItemService service;

	@RequestMapping("info")
	public ModelAndView info(Integer item) {
		ModelAndView mav = new ModelAndView();
		
		  //item : id 에 해당하는 db 레코드 정보를 한개 저장 객체
		  
		  Item items = service.getItem(item); 
		  mav.addObject("items",items); //item 객체에
		 // "items" 이름 설정 System.out.println(items);
		 
		return mav;
	}
}
