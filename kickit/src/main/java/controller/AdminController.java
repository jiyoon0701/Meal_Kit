package controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import dto.Item;
import dto.ItemPurchase;
import dto.User;
import service.ItemPurchaseService;
import service.ItemService;
import service.UserServiceImpl;

@Controller
@RequestMapping("admin")
public class AdminController {
	
	@Autowired
	ItemService itemService;
	
	@Autowired
	ItemPurchaseService itemPurchaseService;
	
	@GetMapping("main")
	public String getAdmin(Model model) {
		System.out.println("start getAdmin Method");
		List<ItemPurchase> revenues = itemPurchaseService.getRevenue();
		List<Item> items = itemService.getItem();
		JSONObject quantities = new JSONObject();
		for(Item item : items) {
			quantities.put(item.getItem(),item.getQuantity());
		}
		int index = revenues.toString().indexOf("=");
		model.addAttribute("itemPurchaseList",revenues.toString().substring(index+1));
		model.addAttribute(items);
		model.addAttribute("quantities",quantities);
		System.out.println(model);
		return "admin/main";
	}
	
	@GetMapping("accessDenied")
	public String AccessDenied() {
		return "admin/accessDenied";
	}
	
	
}
