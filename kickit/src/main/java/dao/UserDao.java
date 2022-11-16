package dao;

import dto.User;

public interface UserDao {
	
	public void insert(User user);
	public User selectOne(String email);
	public void updateUserProfile(User user);
	public void updateUserPoint(int point, String email);
}
