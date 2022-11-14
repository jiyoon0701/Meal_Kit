package dao.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import dto.POARDto;

@Mapper
public interface ReviewMapper {
	@Insert("insert into Review(id,date,content,star,itemCode) values(#{id},curdate(),#{content},#{star},#{itemCode})")
	public void insertReview(Map<String, Object> param);
	
	@Select("select P.id,I.item,P.itemCode,I.price,I.file_name,P.quantity from PurchaseOrder as P, Item as I where P.itemCode = I.itemCode and P.id = ${id}")
	public POARDto selectReviewFormatById(Map<String, Object> param);
}
