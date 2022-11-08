package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ItemDao;
import dto.Item;


public interface ItemService {
	
	
	// item 등록
	public void create(Item item);
	
	
}
