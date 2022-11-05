package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ItemDao;
import dto.Item;

@Service
public class ItemService {
	@Autowired
	private ItemDao itemDao;
	
	public Item getItemAll() {
		return itemDao.selectAll();
	}
}
