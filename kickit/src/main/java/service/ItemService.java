package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ItemDao;
import dto.Item;

@Service
public class ItemService {
	
	@Autowired
	private ItemDao itemDao;

	public Item getItem(Integer item) {
		// TODO Auto-generated method stub
		return itemDao.getItem(item);
	}
	/*
	 * // public Item getItem(Integer item) { // // TODO Auto-generated method stub
	 * // return null; // }
	 */}
