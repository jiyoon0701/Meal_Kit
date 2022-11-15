package dao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import dao.ItemPurchaseDao;
import dto.ItemPurchase;

public interface ItemPurchaseMapper {
	@Select("select id, itemCode, email, date, quantity from PurchaseOrder where email=#{email} ")
	List<ItemPurchase> selectByPurchase(Map<String, Object>param);
}