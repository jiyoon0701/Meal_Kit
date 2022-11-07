package dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.mapper.AdminMapper;
import dto.Item;

@Repository
public class ItemDao {
	
	@Autowired
	private SqlSessionTemplate template;
	
	public void insert(Item item) {
		template.getMapper(AdminMapper.class).insert(item);
	}

}
