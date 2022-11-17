package controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dto.Cart;
import dto.CartList;
import dto.ItemPurchase;
import dto.PurchaseOrder;
import dto.User;
import service.CartService;
import service.CartServiceImpl;
import service.ItemPurchaseService;
import service.ItemService;
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
	
	@Autowired
	ItemService service;
	
	@GetMapping("")
	public String getUser(Principal principal, Model model, PurchaseOrder purchaseOrder) throws Exception {
		
		String email = principal.getName();
		int totalPrice = 0;
		int totalqauntity = 0;
		User user = userService.getUser(email);
		List<ItemPurchase> itemPuchase = itemPurchaseService.getItemPurchase(email);
		List<CartList> cartList = cartservice.getCart(email);
		
		for (CartList CL : cartList) {
			totalPrice += CL.getPrice();
			totalqauntity += CL.getQuantity();
		}
		model.addAttribute("totalqauntity", totalqauntity);
		model.addAttribute("totalPrice", totalPrice);
		model.addAttribute("itemPuchase", itemPuchase);
		model.addAttribute("userinfo", user);
		model.addAttribute("cartList", cartList);
	
		return "user/mypage";
	}

}