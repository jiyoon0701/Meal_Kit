package dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.mapper.CartMapper;
import dao.mapper.UserMapper;
import dto.CartList;

@Repository
public class CartDaoImpl implements CartDao{
	
	@Autowired
	private SqlSessionTemplate template;
	private Map<String,Object> param = new HashMap<>();

	
	@Override
	public List<CartList>getCart(String email) {

		return template.getMapper(CartMapper.class).selectCart(email);
		
	}
	
	@Override
	public void deleteCart(int id, String email) {
		param.clear();
		param.put("id", id);
		param.put("email", email);
		template.getMapper(CartMapper.class).deleteCart(param);

	}
}