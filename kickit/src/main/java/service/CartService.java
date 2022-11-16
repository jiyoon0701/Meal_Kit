package service;

import java.util.List;

import dto.Cart;
import dto.CartList;

public interface CartService {
	
	public List<CartList> getCart(String email) throws Exception;
	public void deleteCart(int id, String email);

}
