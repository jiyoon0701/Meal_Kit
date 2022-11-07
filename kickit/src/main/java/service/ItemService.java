package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ItemDao;
import dto.Item;

@Service
public class ItemService {
	@Autowired
	private ItemDao itemDao;
	
	public List<Item> getItemAll() {
		return itemDao.selectAll();
	}
	
}
