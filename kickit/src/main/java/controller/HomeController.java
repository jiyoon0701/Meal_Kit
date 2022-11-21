package controller;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
public class HomeController {

	@RequestMapping("")
	public String home() {
		return "view/main";
	}
}
