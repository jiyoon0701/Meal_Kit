package controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dto.User;
import service.UserService;

@Controller
@RequestMapping("userProfile")
public class UserEditController {
	@Autowired 
	UserService userService;

	@GetMapping("")
	public String getUserProfile(Model model, Principal principal) {
		String email = principal.getName();
		System.out.println("start getUserProfile Method");
		User user = userService.getUser(email);
		model.addAttribute("user",user);
		System.out.println(user);
		return "user/userProfile";
	}
	@PostMapping("")
	public String postUserProfile( User user) {
		System.out.println("start postUserProfile Method");
		System.out.println(user);
		userService.updateUserProfile(user);
		return "redirect:/userProfile";
	}
	

}
