package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ItemDao;
import dto.Item;

@Service
public class ItemService {
	
	@Autowired
	private ItemDao itemDao;
	
	// item 등록
	public void itemInsert(Item item) {
		itemDao.insert(item);
	}
	
	
}
