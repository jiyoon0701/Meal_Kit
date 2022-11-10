package dao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import dto.Item;

public interface ItemMapper {
	@Select("select itemCode, item, price,category,recommend,buy,star from Item ")
	List<Item> selectAll();
	
	@Select("select I.itemCode,I.item,I.price,I.category,I.recommend,I.buy,I.star, count(R.id) as rvCount from Item as I left join Review as R on I.itemCode =R.itemCode where category = #{category} group by itemCode")
	List<Item> selectByCategory(Map<String, Object> param);
	
	@Select("select I.itemCode,I.item,I.price,I.category,I.recommend,I.buy,I.star, count(R.id) as rvCount from Item as I left join Review as R on I.itemCode =R.itemCode group by itemCode order by ${order}")
	List<Item> selectByOrder(Map<String, Object> param);

	@Select("select I.itemCode,I.item,I.price,I.category,I.recommend,I.buy,I.star, count(R.id) as rvCount from Item as I left join Review as R on I.itemCode =R.itemCode where category = #{category} group by I.itemCode order by ${order}")
	List<Item> selectByCategoryAndOrder(Map<String,Object> param);
	
	@Select("select * from Item where item like '%${keyword}%'")
	List<Item> selectByKeyword(Map<String,Object> param);
}