package service;

import dto.User;

public interface UserService {
	public void userInsert(User user);
	public User getUser(String email);
	public void updateUserProfile(User user);
	public void updateUserPoint(int point, String email);
	public void reviewPoint(String email);
}
