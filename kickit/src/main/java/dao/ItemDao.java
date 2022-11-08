package dao;

import java.util.List;
import dto.Item;

public interface ItemDao {
	public List<Item> selectAll();
	public List<Item> selectByCategory(String category);
	public void create(Item item);
}