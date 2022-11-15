package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.CartDao;
import dto.Cart;

@Service
public class CartServiceImpl implements CartService {
	@Autowired
	private CartDao cartDao;
	
	@Override
	public List<Cart>getCart(String email){
		List<Cart> cart = cartDao.getCart(email);
		return cart;
	}

}
