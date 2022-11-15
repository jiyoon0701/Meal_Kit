package dao;

import java.util.List;

import dto.Cart;
import dto.CartList;

public interface CartDao {
	public List<CartList> getCart(String email);

}
