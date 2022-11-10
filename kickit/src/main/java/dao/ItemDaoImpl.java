package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.mapper.ItemMapper;
import dto.Cart;
import dto.Item;
import dto.Review;


@Repository
public class ItemDaoImpl implements ItemDao{
	
	@Autowired
	private SqlSessionTemplate template;
	private Map<String,Object> param = new HashMap<>();
	public Item getItem(Integer item) {
		param.clear();
		param.put("item", item);
	    return template.getMapper(ItemMapper.class).getItem(param);	
	}
	public List<Review> getReview(Integer item) {
		// TODO Auto-generated method stub
		param.clear();
		param.put("item", item);
		return template.getMapper(ItemMapper.class).getReview(param);
	}
	public void setCart(Cart cart) {
		// TODO Auto-generated method stub
		template.getMapper(ItemMapper.class).setCart(cart);
	}
	
}
