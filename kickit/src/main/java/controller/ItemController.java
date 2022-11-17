package controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dto.Cart;
import dto.Image;
import dto.Item;
import dto.Review;
import service.ItemServiceImpl;

@Controller
@RequestMapping("content")
public class ItemController {

	@Autowired
	ItemServiceImpl service;

	@GetMapping("info")
	public ModelAndView info(@RequestParam("item") Integer item) {
		ModelAndView mav = new ModelAndView();
		ArrayList<String> pictures = new ArrayList<>();
		Item items = service.getItem(item);
		List<Review> review = service.getReview(item);
		// 이미지 객체 가져오기
		Image picture = service.selectPicture(item);

		pictures.add(picture.getPicture1());
		pictures.add(picture.getPicture2());
		pictures.add(picture.getPicture3());
		pictures.add(picture.getPicture4());
		pictures.add(picture.getPicture5());

		mav.addObject("items", items); // item 객체에
		mav.addObject("Review", review);
		mav.addObject("pictures", pictures);
		return mav;
	}

	@PostMapping("cart") // 장바구니
	public String cart(@RequestParam int itemCode, @RequestParam int Quantity, Cart cart, Principal principal) {

		String email = principal.getName();
		cart.setItemCode(itemCode);
		cart.setQuantity(Quantity);
		cart.setEmail(email);
		service.setCart(cart);
		
		return "redirect:/content/info?item=" + cart.getItemCode();
	}

	
}
