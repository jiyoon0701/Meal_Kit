package dao.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import dto.Item;

@Repository
public interface ItemMapper {
	@Select("select * from Item where itemCode=#{item}")
	Item getItem(Map<String, Object> param);
 
	
	//Item getItem(int item);

}
