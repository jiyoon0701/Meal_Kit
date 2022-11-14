package dao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import dto.Cart;

@Repository
public interface CartMapper {
	
	@Select("select * from Cart where email=#{email}")
	List<Cart> selectCart(Map<String, Object> param);

}
