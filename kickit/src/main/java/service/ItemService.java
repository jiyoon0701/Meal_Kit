package service;

import java.util.List;

import dto.Item;

public interface ItemService {
	
	public List<Item> getItem();
	public List<Item> getItem(String category);
	public List<Item> getItem(String category, String Order);
	public List<Item> getItemByOrder(String order);
	public List<Item> getItemByKeyword(String keyword);
}