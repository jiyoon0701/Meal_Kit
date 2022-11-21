package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.mapper.ItemMapper;

import dto.Cart;
import dto.Image;
import dto.Item;
import dto.PurchaseOrder;
import dto.Review;

@Repository
public class ItemDaoImpl implements ItemDao {
	@Autowired
	private SqlSessionTemplate template;
	private Map<String, Object> param = new HashMap<>();

	@Override
	public List<Item> selectItem() {
		return template.getMapper(ItemMapper.class).selectAll();
	}

	@Override
	public List<Item> selectItemByCategory(String category) {
		param.clear();
		param.put("category", category);
		return template.getMapper(ItemMapper.class).selectByCategory(param);
	}

	@Override
	public List<Item> selectItemByOrder(String order) {
		param.clear();
		param.put("order", order);
		return template.getMapper(ItemMapper.class).selectByOrder(param);
	}

	@Override
	public List<Item> selectItemByCategoryAndOrder(String category, String order) {
		param.clear();
		param.put("order", order);
		param.put("category", category);
		System.out.println("param :" + param);
		return template.getMapper(ItemMapper.class).selectByCategoryAndOrder(param);
	}

	@Override
	public List<Item> selectItemByKeyword(String keyword) {
		param.clear();
		param.put("keyword", keyword);
		return template.getMapper(ItemMapper.class).selectByKeyword(param);
	}

	@Override
	public Item getItem(Integer item) {
		param.clear();
		param.put("item", item);
		return template.getMapper(ItemMapper.class).selectByItem(param);
	}

	@Override
	public List<Review> getReview(Integer item) {
		// TODO Auto-generated method stub
		param.clear();
		param.put("item", item);
		return template.getMapper(ItemMapper.class).getReview(param);
	}

	@Override
	public void setCart(Cart cart) {
		// TODO Auto-generated method stub
		template.getMapper(ItemMapper.class).setCart(cart);
	}

	@Override
	public void setPurchaseOrder(PurchaseOrder po) {
		// TODO Auto-generated method stub
		template.getMapper(ItemMapper.class).setPurchaseOrder(po);
	}

	@Override
	public void deleteItem(int id) {
		// TODO Auto-generated method stub
		template.getMapper(ItemMapper.class).deleteCart(id);
	}
	

	@Override
	public Image selectPicture(int itemCode) {
		// TODO Auto-generated method stub
		return template.getMapper(ItemMapper.class).selectPicture(itemCode);
		
	}
	
	@Override
	   public void create(Item item) {      
	        template.getMapper(ItemMapper.class).itemInsert(item);
	   }

	@Override
	public void insertPicture(List<String> arr) {
		// TODO Auto-generated method stub
		param.clear();
		param.put("picture1", arr.get(0));
		param.put("picture2", arr.get(1));
		param.put("picture3", arr.get(2));
		param.put("picture4", arr.get(3));
		param.put("picture5", arr.get(4));
		
		template.getMapper(ItemMapper.class).insertPicture(param);
	}

	public void deleteItemByItemCode(String itemCode) {
		// TODO Auto-generated method stub
		param.clear();
		param.put("itemCode", itemCode);
		template.getMapper(ItemMapper.class).deleteItem(param);
	}


}

