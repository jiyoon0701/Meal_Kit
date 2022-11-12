package dao;

import java.util.List;
import dao.mapper.ItemMapper;
import dto.Item;

public interface ItemDao {
	public List<Item> selectItem();
	public List<Item> selectItemByCategory(String category);
	public List<Item> selectItemByOrder(String order);
	public List<Item> selectItemByCategoryAndOrder(String category, String order);
	public List<Item> selectItemByKeyword(String keyword);
	public void create(Item item);
}

