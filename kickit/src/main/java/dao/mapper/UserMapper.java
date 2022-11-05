package dao.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import dto.User;

public interface UserMapper {

	@Insert("insert into User "
     + " (email, password,name)"
+ " values(#{email}, #{password},#{name})")
	void insert(User user);

	@Select("select * from User where email=#{email}")
	User selectOne(Map<String, Object> param);

}
