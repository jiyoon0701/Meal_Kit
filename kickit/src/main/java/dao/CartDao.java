package dao;

import java.util.List;

import dto.Cart;

public interface CartDao {
	public List<Cart> getCart(String email);

}
