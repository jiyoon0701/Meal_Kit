package dao.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Select;

import dto.Cart;
import dto.Image;
import dto.Item;
import dto.PurchaseOrder;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;


import dto.Review;

@Repository
public interface ItemMapper {
	@Select("select * from Item where itemCode=#{item}")
	Item selectByItem(Map<String, Object> param);

	@Select("select * from Review where itemCode=#{item}")
	List<Review> getReview(Map<String, Object> param);

	@Insert("insert into Cart(itemCode, email, quantity) values(#{itemCode},#{email}, #{quantity})")
	void setCart(Cart cart);

	@Select("select * from Item ")
	List<Item> selectAll();

	@Select("select I.itemCode,I.item,I.price,I.category,I.recommend,I.buy,I.star, count(R.id) as rvCount from Item as I left join Review as R on I.itemCode =R.itemCode where category = #{category} group by itemCode")
	List<Item> selectByCategory(Map<String, Object> param);

	@Select("select I.itemCode,I.item,I.price,I.category,I.recommend,I.buy,I.star, count(R.id) as rvCount from Item as I left join Review as R on I.itemCode =R.itemCode group by itemCode order by ${order}")
	List<Item> selectByOrder(Map<String, Object> param);

	@Select("select I.itemCode,I.item,I.price,I.category,I.recommend,I.buy,I.star, count(R.id) as rvCount from Item as I left join Review as R on I.itemCode =R.itemCode where category = #{category} group by I.itemCode order by ${order}")
	List<Item> selectByCategoryAndOrder(Map<String, Object> param);

	@Select("select * from Item where item like '%${keyword}%'")
	List<Item> selectByKeyword(Map<String, Object> param);

	@Insert("insert into PurchaseOrder(itemCode, email, quantity) values(#{itemCode}, #{email}, #{quantity})")
	void setPurchaseOrder(PurchaseOrder po);

	@Select("select picture1, picture2, picture3, picture4, picture5 from Picture where itemCode = #{itemCode}")	
	Image selectPicture(int itemCode);
	
	@Insert("insert into Item(item, price, content, quantity, category, file_name)values(#{item},#{price},#{content},#{quantity},#{category},#{file_name})")
	void itemInsert(Item item);
	
	@Insert("insert into Picture( picture1, picture2, picture3, picture4, picture5)values(#{picture1},#{picture2},#{picture3},#{picture4},#{picture5})")
	void insertPicture(Map<String, Object> param);
	
	@Delete("delete from Item where itemCode=#{itemCode}")
	void deleteItem(Map<String, Object> param);
	
	@Delete("delete from Cart where id=#{id}")
	void deleteCart(int id);
}