package dao;


import java.util.List;
import java.util.Map;

import dto.Cart;
import dto.Item;
import dto.Review;

public interface ItemDao {
	public Item getItem(Integer item);
	public List<Review> getReview(Integer item);
	public void setCart(Cart cart);
}
