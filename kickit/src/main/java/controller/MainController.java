package controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dto.Item;
import dto.User;
import service.ItemService;
import service.ItemServiceImpl;
import service.UserService;

@Controller
@RequestMapping("main")
public class MainController {

	@Autowired
	private ItemService itemService;
	
	@GetMapping("")
	public String getItemAll(Model model,HttpServletRequest request) {
		System.out.println("start getItemAll method");
		String category = request.getParameter("category");
		String order = request.getParameter("order");
		String keyword = request.getParameter("keyword");
		System.out.println("category :" + category+" order : "+order);

		List<Item> items = null;
		if (keyword == null) keyword = "";
		
		if(!keyword.equals("")) {
			System.out.println("start getItemByKeyword() method");
			items = itemService.getItemByKeyword(keyword);
		}else {
			if ((category == null || category.equals("전체")) && (order==null || order.equals("none"))) {
				System.out.println("start getItem() method");
				items = itemService.getItem();
			}else if (!category.equals("전체") && !order.equals("none")) {
				System.out.println("start getItem(category,order)");
				items = itemService.getItem(category,order);
			}else if(!category.equals("전체")&& order.equals("none")) { 
				System.out.println("start getItem(category)");
				items = itemService.getItem(category);
			}else {
				System.out.println("start getItemByOrder method");
				items = itemService.getItemByOrder(order);
			}
		}
		for(Item item : items) {
			System.out.println(item);
		}
		model.addAttribute("items",items);
		return "main";
	}
	

}
