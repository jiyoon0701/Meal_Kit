package dao;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.mapper.ItemMapper;

import dto.Item;


@Repository
public class ItemDao {
	
	@Autowired
	private SqlSessionTemplate template;
	private Map<String,Object> param = new HashMap<>();
	public Item getItem(int item) {
		param.clear();
		param.put("item", item);
	    return template.getMapper(ItemMapper.class).getItem(param);	
	}

}
