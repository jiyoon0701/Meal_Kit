package dao;


import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.mapper.CartMapper;
import dto.CartList;

@Repository
public class CartDaoImpl implements CartDao{
	
	@Autowired
	private SqlSessionTemplate template;
	
	@Override
	public List<CartList>getCart(String email) {

		return template.getMapper(CartMapper.class).selectCart(email);
		
	}
}