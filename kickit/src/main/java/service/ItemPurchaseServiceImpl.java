package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ItemPurchaseDao;
import dto.ItemPurchase;



@Service
public class ItemPurchaseServiceImpl implements ItemPurchaseService{
	@Autowired
	private ItemPurchaseDao itemPurchaseDao;
	

	@Override
	public List<ItemPurchase> getItemPurchase(String email) {
		return itemPurchaseDao.selectByPurchase(email);
	}


	@Override
	public List<ItemPurchase> getRevenue() {
		// TODO Auto-generated method stub
		return itemPurchaseDao.selectRevenue();
	}
	

}