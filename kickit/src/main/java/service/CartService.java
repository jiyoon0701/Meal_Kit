package service;

import java.util.List;

import dto.Cart;

public interface CartService {
	
	public List<Cart> getCart(String email) throws Exception;

}
