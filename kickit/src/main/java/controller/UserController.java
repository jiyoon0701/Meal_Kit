package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dto.User;
import service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("join")
	public String getUser() {
		
		return "user/join";
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
			mav.addObject("result","회원가입 실패");
			return mav;
		}
		mav.setViewName("redirect:/");
		return mav;
	}
}
