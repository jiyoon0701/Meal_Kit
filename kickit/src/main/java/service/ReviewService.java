package service;

import dto.POARDto;
import dto.Review;

public interface ReviewService {
	public void setReviewById(Review review);
	public POARDto getReviewFormatById(int id);
}
