package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.CartDao;
import dto.CartList;

@Service
public class CartServiceImpl implements CartService {
	@Autowired
	private CartDao cartDao;
	
	@Override
	public List<CartList>getCart(String email){
		List<CartList> cart = cartDao.getCart(email);
		return cart;
	}
	
	@Override
	public void deleteCart(int id, String email) {
		cartDao.deleteCart(id, email);
	}

}
