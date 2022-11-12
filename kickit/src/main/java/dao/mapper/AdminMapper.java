package dao.mapper;

import org.apache.ibatis.annotations.Insert;

import dto.Item;

public interface AdminMapper {
	
	// 상품 등록
	@Insert("insert into item(item, price, content, quantity, category, recommend, buy, star)values(#{item},#{price},#{content},#{quantity},#{category},#{recommend},#{buy},#{star})")
	void insert(Item item);
	
}
