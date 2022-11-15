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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dto.Cart;
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
	private CartServiceImpl cartservice;
	
	@Autowired
	private ItemPurchaseService itemPurchaseService;
	
	
	
	
	
	@GetMapping("")
	public String getItemPurchase(Model model, HttpServletRequest request, Principal principal) {
		System.out.println("start getItemPurchase method");
		String email = principal.getName();
		System.out.println("email :"+ email);
		
		List<ItemPurchase> items = itemPurchaseService.getItemPurchase(email);
		model.addAttribute("items",items);
		return "mypage";
	}
	
	public String getUser(Principal principal, Model model) {
		String email = principal.getName();
		model.addAtrribute("userinfo", (User)UserService.getUser(email));
		return "mypage";
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public void getCartList(HttpSession session, Model model) throws Exception {
	   
	   User user = (User)session.getAttribute("user");
	   String userEmail = user.getEmail();
	   
	   List<Cart> cartList = CartService.getCart(userEmail);
	   
	   model.addAttribute("cartList", cartList);
	   
	}
	
	/*
	 * @GetMapping("") public String getCart(Cart cart, Principal principal, Model
	 * model) {
	 * 
	 * String email = principal.getName();
	 * 
	 * Cart.getEmail(); model.addAllAttributes("cartInfo", CartService) return
	 * "mypage"; }
	 */
	

}