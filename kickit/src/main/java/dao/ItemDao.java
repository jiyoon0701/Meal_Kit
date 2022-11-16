package dao;

import java.util.List;

import dto.Cart;
import dto.Image;
import dto.Item;
import dto.PurchaseOrder;
//import dto.Cart;
import dto.Review;

public interface ItemDao {
	public Item getItem(Integer item);
	public List<Review> getReview(Integer item);
	public void setCart(Cart cart);
	public List<Item> selectItem();
	public List<Item> selectItemByCategory(String category);
	public List<Item> selectItemByOrder(String order);
	public List<Item> selectItemByCategoryAndOrder(String category, String order);
	public List<Item> selectItemByKeyword(String keyword);
	public void setPurchaseOrder(PurchaseOrder po);
	public void deleteItem(int id);
	public Image selectPicture(int itemCode);
	public void create(Item item);
	public void insertPicture(List<String> arr);
}
