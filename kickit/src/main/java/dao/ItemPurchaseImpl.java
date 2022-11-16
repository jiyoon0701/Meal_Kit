package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.mapper.ItemPurchaseMapper;
import dto.ItemPurchase;

@Repository
public class ItemPurchaseImpl implements ItemPurchaseDao{
	@Autowired
	private SqlSessionTemplate template;
	private Map<String, Object> param = new HashMap<>();
	
	@Override
	public List<ItemPurchase> selectByPurchase(String email) {
		param.clear();
		param.put("email",email);
		return template.getMapper(ItemPurchaseMapper.class).selectByPurchase(param);
	}

	@Override
	public List<ItemPurchase> selectRevenue() {
		// TODO Auto-generated method stub
		return template.getMapper(ItemPurchaseMapper.class).selectRevenue();
	}
}