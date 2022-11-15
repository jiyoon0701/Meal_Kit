package dao;

import java.util.List;

import dto.ItemPurchase;

public interface ItemPurchaseDao {
	public List<ItemPurchase> selectByPurchase(String email);
}