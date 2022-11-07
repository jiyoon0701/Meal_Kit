package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dto.User;
import service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("join")
	public User getUser(@RequestParam("email") String email) {
		System.out.println("start getUser Contorller");
		User user = service.getUser(email);
		System.out.println(user);
		return user;
	}

	@PostMapping("join")
	public ModelAndView join (User user) {
		ModelAndView mav = new ModelAndView();

		try {
			// user.setRole(false);
			service.userInsert(user);
			mav.addObject("user",user);

		} catch(DataIntegrityViolationException e) {
			e.printStackTrace();
			mav.addObject("result","�쉶�썝媛��엯 �떎�뙣");
			return mav;
		}
		mav.setViewName("redirect:/");
		return mav;
	}
}
