package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.UserDetails;

public interface UserDetailsDAO {
	public boolean saveUser(UserDetails user);
	public boolean updateUser(UserDetails user);
	public boolean removeUser(String userId);
	public UserDetails getUser(String userId);
	public List<UserDetails> getUserList();
	public UserDetails isValidUser(String userId, String password);
	public boolean isUser(String userId);
	
}
