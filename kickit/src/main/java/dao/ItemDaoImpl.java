package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.mapper.ItemMapper;
import dao.mapper.UserMapper;
import dto.Item;
import dto.User;

@Repository
public class ItemDaoImpl implements ItemDao{
	@Autowired
	private SqlSessionTemplate template;
	private Map<String,Object> param = new HashMap<>();

	@Override
	public List<Item> selectItem() {
		return template.getMapper(ItemMapper.class).selectAll();
	}

	@Override
	public List<Item> selectItemByCategory(String category) {
		param.clear();
		param.put("category",category);
		return template.getMapper(ItemMapper.class).selectByCategory(param);
	}

	@Override
	public List<Item> selectItemByOrder(String order) {
		param.clear();
		param.put("order",order);
		return template.getMapper(ItemMapper.class).selectByOrder(param);
	}

	@Override
	public List<Item> selectItemByCategoryAndOrder(String category, String order) {
		param.clear();
		param.put("order", order);
		param.put("category", category);
		System.out.println("param :"+param);
		return template.getMapper(ItemMapper.class).selectByCategoryAndOrder(param);
	}

	@Override
	public List<Item> selectItemByKeyword(String keyword) {
		param.clear();
		param.put("keyword", keyword);
		return template.getMapper(ItemMapper.class).selectByKeyword(param);
	}
}
