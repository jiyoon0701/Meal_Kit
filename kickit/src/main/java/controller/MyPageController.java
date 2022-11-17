package controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	private CartService cartService;

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
		List<CartList> cartList = cartService.getCart(email);
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
	public String postpoint(int point, Principal principal) {
		String email = principal.getName();
		userService.updateUserPoint(point,email);
		System.out.println(point);
		return "redirect:/mypage/mypage2";
	}
	
	@GetMapping("mypage2/deleteCart")
	public String deletecart(@RequestParam("id") int id, Principal principal){
		String email = principal.getName();
		System.out.println(email);
		cartService.deleteCart(id, email);
		return"redirect:/mypage/mypage2";
	}
	
}