package com.alchemy.api;

import java.util.List;

public interface IUserDao {
	public List<User> getUsers();
	public User getUser(String email);
	public void addUser(User user);
	public void deleteUser(String userId);
	public void updateUser(User user);	
}
