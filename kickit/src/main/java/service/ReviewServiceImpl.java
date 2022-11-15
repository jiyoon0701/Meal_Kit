package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ReviewDao;
import dto.POARDto;
import dto.Review;

@Service
public class ReviewServiceImpl implements ReviewService{

	@Autowired
	ReviewDao reviewDao;
	
	@Override
	public void setReviewById(Review review) {
		// TODO Auto-generated method stub
		reviewDao.insertReview(review);
	}

	@Override
	public POARDto getReviewFormatById(int id) {
		// TODO Auto-generated method stub
		return reviewDao.selectReviewFormatById(id);
	}

}
