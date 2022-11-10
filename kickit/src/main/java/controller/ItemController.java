package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//import dto.Cart;
import dto.Item;
import dto.Review;
import service.ItemServiceImpl;

@Controller
@RequestMapping("content")
public class ItemController {

	@Autowired
	ItemServiceImpl service;
	Map<String, Object> param = new HashMap();
	
	@GetMapping("info")
	public ModelAndView info(@RequestParam("item") Integer item) {
		ModelAndView mav = new ModelAndView();
		
		  Item items = service.getItem(item); 
		  List<Review> review = service.getReview(item);
		  mav.addObject("items",items); //item 객체에
		  mav.addObject("Review",review);
		return mav;
	}
	
//	@PostMapping("cart")
//	public String cart(Cart cart, HttpSession session) {
//		
//		String email = null;
//		System.out.println(cart.getItemCode());
//		try {
//			email = (String) session.getAttribute("email");
//			System.out.println(email);
//			if (email != null) {
//				cart.setEmail(email);
//				service.setCart(cart); 
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//		}  
//		 return "redirect:/content/info?item="+cart.getItemCode();
//	}	
	
}
