package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dto.POARDto;
import dto.Review;
import service.ReviewService;

@Controller
@RequestMapping("review")
public class ReviewController {
	@Autowired
	ReviewService reviewService;
	
	@GetMapping("")
	public String getReviewById(@RequestParam("id") int id,Model model) {
		System.out.println("start getReviewById Method");
		POARDto review = reviewService.getReviewFormatById(id);
		model.addAttribute(review);
		System.out.println(model);
		return "review/registerReview";
	}
	
	@PostMapping("")
	public String setReviewById(Review review) {
		System.out.println("start setReviewById");
		System.out.println(review);
		reviewService.setReviewById(review);

		return "redirect:/review?id="+Integer.toString(review.getId());
	}
	
}
