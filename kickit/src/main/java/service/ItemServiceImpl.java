package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ItemDao;
import dto.Cart;
import dto.Image;
import dto.Item;
import dto.PurchaseOrder;
import dto.Review;

@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private ItemDao itemDao;

	@Override
	public List<Item> getItem() {
		// TODO Auto-generated method stub
		return itemDao.selectItem();
	}

	@Override
	public List<Item> getItem(String category) {
		// TODO Auto-generated method stub
		return itemDao.selectItemByCategory(category);
	}

	@Override
	public List<Item> getItem(String category, String Order) {
		// TODO Auto-generated method stub
		return itemDao.selectItemByCategoryAndOrder(category, Order);
	}

	@Override
	public List<Item> getItemByOrder(String order) {
		// TODO Auto-generated method stub
		return itemDao.selectItemByOrder(order);
	}

	@Override
	public List<Item> getItemByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return itemDao.selectItemByKeyword(keyword);
	}

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

	@Override
	public void setPurchaseOrder(PurchaseOrder po) {
		// TODO Auto-generated method stub
		itemDao.setPurchaseOrder(po);
	}

	@Override

	public void deleteItem(int id) {
		// TODO Auto-generated method stub
		itemDao.deleteItem(id);
	}

	@Override
	public Image selectPicture(int itemCode) {
		// TODO Auto-generated method stub
		return itemDao.selectPicture(itemCode);
	}

	public void create(Item item) {
		itemDao.create(item);
	}

	@Override
	public void insertPicture(List<String> arr) {
		// TODO Auto-generated method stub
		itemDao.insertPicture(arr);
	}

	@Override
	public void deleteItemByItemCode(String itemCode) {
		// TODO Auto-generated method stub
		itemDao.deleteItemByItemCode(itemCode);
	}

	@Override
	public void updateItemQuantity(int itemCode, int quantity) {
		// TODO Auto-generated method stub
		itemDao.updateItemQuantity(itemCode, quantity);
	}
}