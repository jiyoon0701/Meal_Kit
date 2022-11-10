package service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ItemDaoImpl;
import dto.Cart;
import dto.Item;
import dto.Review;

@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	private ItemDaoImpl itemDao;

	public Item getItem(Integer item) {
		// TODO Auto-generated method stub
		return itemDao.getItem(item);
	}

	@Override
	public List<Review> getReview(Integer item) {
		// TODO Auto-generated method stub
		return itemDao.getReview(item);
	}

	public void setCart(Cart cart) {
		// TODO Auto-generated method stub
		itemDao.setCart(cart);
	}

}