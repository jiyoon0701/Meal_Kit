package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dto.Item;
import dto.User;
import service.ItemService;

@Controller
@RequestMapping("main")
public class MainController {

	@Autowired
	private ItemService service;
	
	@GetMapping("test")
	public List<Item> getItemAll() {
		System.out.println("start getUser Contorller");
		List<Item> items = service.getItemAll();
		return items;
	}
}
