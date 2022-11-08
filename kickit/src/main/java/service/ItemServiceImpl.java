package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ItemDao;
import dto.Item;

@Service
public class ItemServiceImpl implements ItemService{
	@Autowired
	private ItemDao itemDao;
	
	/*
	@Override
	public List<Item> getItemAll() {
		return itemDao.selectAll();
	}
	
	@Override
	public List<Item> getItemByCategory(String category){
		return itemDao.selectByCategory(category);
	}
	*/
	
	@Override
	public void create(Item item) {
		itemDao.create(item);
	}
	
}