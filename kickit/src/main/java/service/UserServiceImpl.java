package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UserDao;
import dao.UserDaoImpl;
import dto.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public void userInsert(User user) {
		userDao.insert(user);
	}

	@Override
	public User getUser(String email) {
		return userDao.selectOne(email);

	}

	@Override
	public void updateUserProfile(User user) {
		// TODO Auto-generated method stub
		userDao.updateUserProfile(user);

	}

	@Override
	   public void updateUserPoint(int point, String email) {
	      userDao.updateUserPoint(point, email);
	   }

}
