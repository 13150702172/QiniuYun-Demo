package com.mybatis.dao;

import java.util.List;

import com.mybatis.entity.User;

public interface UserDao {
	List<User> getUser();
	
	User getUserById(int id);
	
	void insertUser(User user);
	
}
