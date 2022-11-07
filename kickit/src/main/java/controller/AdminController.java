package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dto.Item;
import service.ItemService;

@Controller
@RequestMapping("admin")
public class AdminController {
	
	@Autowired
	private ItemService service;
	
	@PostMapping("enrolled")
	public ModelAndView enrolled (Item item) {
		ModelAndView mav = new ModelAndView();
		
		try {
			service.itemInsert(item);
			mav.addObject("item",item);
			
			
		} catch(DataIntegrityViolationException e) {
			e.printStackTrace();
			mav.addObject("result","상품등록성공");
			return mav;
		}
		mav.setViewName("redirect:/admin");
		return mav;
		
	}
	
}