package service;

import java.util.List;

import dto.ItemPurchase;

public interface ItemPurchaseService {
	
	public List<ItemPurchase> getItemPurchase(String email);
	
}