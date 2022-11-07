package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dto.Item;
import dto.Review;
import service.ItemServiceImpl;

@Controller
@RequestMapping("content")
public class ItemController {

	@Autowired
	ItemServiceImpl service;

	@RequestMapping("info")
	public ModelAndView info(Integer item) {
		ModelAndView mav = new ModelAndView();
		
		  //item : id 에 해당하는 db 레코드 정보를 한개 저장 객체
		  
		  Item items = service.getItem(item); 
		  List<Review> review = service.getReview(item);
		  mav.addObject("items",items); //item 객체에
		 // "items" 이름 설정 System.out.println(items);
		  mav.addObject("Review",review);
		return mav;
	}
}
