package dao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import dto.Item;

public interface ItemMapper {
	@Select("select itemCode,item,price,category,recommend,buy,star from Item")
	List<Item> selectAll();
	
	@Select("select itemCode,item,price,category,recommend,buy,star from Item where category=#{category}")
	List<Item> selectByCategory(Map<String, Object> param);
	
	// 상품 등록
	@Insert("insert into Item(item, price, content, quantity, category)values(#{item},#{price},#{content},#{quantity},#{category})")
	void itemInsert(Item item);

}