package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.mapper.CartMapper;
import dto.Cart;

@Repository
public class CartDaoImpl implements CartDao{
	@Autowired
	private SqlSessionTemplate template;
	private Map<String, Object> param = new HashMap<>();
	
	@Override
	public List<Cart>selectCart(String email) {
		param.clear();
		param.put("email", email);
		return template.getMapper(CartMapper.class).selectCart(param);
		
	}
}