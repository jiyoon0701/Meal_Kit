package dao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import dao.ItemPurchaseDao;
import dto.ItemPurchase;

public interface ItemPurchaseMapper {
	@Select("select p.id, p.itemCode, p.email, p.date, p.quantity, i.item, i.price, i.file_name from PurchaseOrder p "
			+ "inner join Item i on p.itemCode = i.itemCode where p.email=#{email} ")
	List<ItemPurchase> selectByPurchase(Map<String, Object>param);
	
}