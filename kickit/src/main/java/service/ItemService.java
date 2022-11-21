package service;

import java.util.List;

import dto.Cart;
import dto.Image;
import dto.Item;
import dto.PurchaseOrder;
import dto.Review;

public interface ItemService {
	
	public List<Item> getItem();
	public List<Item> getItem(String category);
	public List<Item> getItem(String category, String Order);
	public List<Item> getItemByOrder(String order);
	public List<Item> getItemByKeyword(String keyword);
	public Item getItem(Integer item);
	public List<Review> getReview(Integer item);
	public void setCart(Cart cart);

	public void create(Item item);
	public void setPurchaseOrder(PurchaseOrder po);
	public void deleteItem(int id);
	public Image selectPicture(int itemCode);
	public void insertPicture(List<String> arr);

	
	public void deleteItemByItemCode(String itemCode);
	public void updateItemQuantity(int itemCode, int quantity);
	

}

