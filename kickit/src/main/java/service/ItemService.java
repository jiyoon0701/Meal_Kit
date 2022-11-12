package service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ItemDao;
import dto.Item;
import java.util.List;


public interface ItemService {
	
	// item 등록
	public void create(Item item);
	public List<Item> getItem();
	public List<Item> getItem(String category);
	public List<Item> getItem(String category, String Order);
	public List<Item> getItemByOrder(String order);
	public List<Item> getItemByKeyword(String keyword);
}