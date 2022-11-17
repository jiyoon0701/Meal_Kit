package dao;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.mapper.UserMapper;
import dto.User;

@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private SqlSessionTemplate template;
	private Map<String,Object> param = new HashMap<>();
	
	@Override
	public void insert(User user) {
	    template.getMapper(UserMapper.class).insert(user);	
	}
	
	@Override
	public User selectOne(String email) {
		param.clear();
		param.put("email", email);
		return template.getMapper(UserMapper.class).selectOne(param);
	}

	@Override
	public void updateUserProfile(User user) {

		param.clear();
		param.put("email", user.getEmail());
		param.put("password",user.getPassword());
		param.put("name", user.getName());
		param.put("tel",user.getTel());
		param.put("address", user.getAddress());
		System.out.println(param);
		
		template.getMapper(UserMapper.class).updateUserProfile(param);
	}
	@Override
	   public void updateUserPoint(int point, String email) {
	      param.clear();
	      param.put("email", email);
	      param.put("point", point);
	      template.getMapper(UserMapper.class).updateUserPoint(param);
	   }

}
