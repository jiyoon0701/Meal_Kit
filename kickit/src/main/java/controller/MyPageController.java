package controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dto.Cart;
import dto.CartList;
import dto.ItemPurchase;
import dto.User;
import service.CartService;
import service.CartServiceImpl;
import service.ItemPurchaseService;
import service.UserService;

@Controller
@RequestMapping("mypage")
public class MyPageController {
	@Autowired
	private CartService cartservice;

	@Autowired
	private ItemPurchaseService itemPurchaseService;

	@Autowired
	private UserService userService;

	@GetMapping("mypage2")
	public String getUser(Principal principal, Model model) throws Exception {
		String email = principal.getName();
		int totalqauntity = 0;
		int totalPrice = 0;
		User user = userService.getUser(email);
		List<ItemPurchase> itemPuchase = itemPurchaseService.getItemPurchase(email);
		List<CartList> cartList = cartservice.getCart(email);
		System.out.print(cartList);
		for (CartList CL : cartList) {
			totalPrice += CL.getPrice();
			totalqauntity++;
		}

		model.addAttribute("totalqauntity", totalqauntity);
		model.addAttribute("totalPrice", totalPrice);
		model.addAttribute("itemPuchase", itemPuchase);
		model.addAttribute("userinfo", user);
		model.addAttribute("cartList", cartList);
		return "user/mypage";
	}

	@PostMapping("mypage2")
	public String postPoint(int price, Principal principal) {
		String email = principal.getName();
		userService.updateUserPoint(price,email);
		
		return "redirect:/mypage/mypage2";
	}
}