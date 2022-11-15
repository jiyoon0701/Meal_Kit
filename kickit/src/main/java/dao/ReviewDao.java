package dao;

import dto.POARDto;
import dto.Review;

public interface ReviewDao {
	public void insertReview(Review review);
	public POARDto selectReviewFormatById(int id);
}
