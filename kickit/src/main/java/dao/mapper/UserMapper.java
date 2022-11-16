package dao.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import dto.User;

@Repository
public interface UserMapper {

	@Insert("insert into User "
     + " (email, password,name,tel,address,authority)"
+ " values(#{email}, #{password},#{name},#{tel},#{address},#{authority})")
	void insert(User user);
 
	@Select("select * from User where email=#{email}")
	User selectOne(Map<String, Object> param);

	@Select("update User set password=#{password},name=#{name},tel=#{tel},address=#{address} where email=#{email}")
	void updateUserProfile(Map<String, Object> param);
	
	@Update("update User set point=#{point} where email=#{email}")
	void updateUserPoint(Map<String, Object> param);
}
