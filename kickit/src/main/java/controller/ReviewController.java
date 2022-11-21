package controller;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import dto.POARDto;
import dto.Review;
import service.ReviewService;
import service.UserService;

@Controller
@RequestMapping("review")
public class ReviewController {
	@Autowired
	ReviewService reviewService;
	
	@Autowired
	UserService userService;
	
	@GetMapping("")
	public String getReviewById(@RequestParam("id") int id,Model model) {
		System.out.println("start getReviewById Method");
		POARDto review = reviewService.getReviewFormatById(id);
		model.addAttribute(review);
		System.out.println(model);
		return "review/registerReview";
	}
	
	@PostMapping("")
	public String setReviewById(@ModelAttribute Review review,HttpServletRequest request,MultipartHttpServletRequest mtfRequest, MultipartFile uploadFile, Principal principal)throws IllegalStateException, IOException {
		System.out.println("start setReviewById");
		String pdfPath = request.getSession().getServletContext().getRealPath("/resources/img/");
		List<MultipartFile> detailImgFileList = mtfRequest.getFiles("file");

		 if(detailImgFileList != null) {
	         String originalFileName = detailImgFileList.get(0).getOriginalFilename();
	         detailImgFileList.get(0).transferTo(new File(pdfPath +originalFileName ));
	         review.setPicture(originalFileName);
	      }
		System.out.println(review);
		reviewService.setReviewById(review); // 리뷰 작성
		try {
			userService.reviewPoint(principal.getName());
		}catch(Exception e) {
			System.out.println("로그인 필요");
		}
		
		return "redirect:/review?id="+Integer.toString(review.getId());
	}
	
}
