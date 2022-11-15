package dao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import dto.Cart;

@Repository
public interface CartMapper {
	
	@Select("select c.id, c.itemCode, c.email, c.quantity"
			+ "i.itemCode, i.item. i.price, i.content, i.file_name, i.category from Cart c "
			+ "inner join Item i on c.itemCode = i.itemCode where c.email=#{email}")
	List<Cart> selectCart(Map<String, Object> param);

}
