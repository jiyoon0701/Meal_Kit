package dao;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.mapper.ReviewMapper;
import dto.POARDto;
import dto.Review;

@Repository
public class ReviewDaoImpl implements ReviewDao{
	@Autowired
	private SqlSessionTemplate template;
	private Map<String,Object> param = new HashMap<>();
	
	@Override
	public void insertReview(Review review) {
		// TODO Auto-generated method stub
		param.clear();
		param.put("id", review.getId());
		param.put("content", review.getContent());
		param.put("star", review.getStar());
		param.put("itemCode", review.getItemCode());
		System.out.println(param);
		template.getMapper(ReviewMapper.class).insertReview(param);
	}

	@Override
	public POARDto selectReviewFormatById(int id) {
		// TODO Auto-generated method stub
		param.clear();
		param.put("id", id);
		return template.getMapper(ReviewMapper.class).selectReviewFormatById(param);
	}
	
}
