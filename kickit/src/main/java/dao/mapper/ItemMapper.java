package dao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import dto.Item;

public interface ItemMapper {
	@Select("select * from Item")
	List<Item> selectAll();
	
	@Select("select * from Item where category=#{category}")
	Item selectByCategory(Map<String, Object> param);

}
