package com.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mybatis.dao.UserDao;
import com.mybatis.entity.User;

@Service
public class UserService {

	@Autowired
	UserDao userDao;

	public List<User> getUser() {
		return userDao.getUser();
	}

	public User getUserById(int id) {
		return userDao.getUserById(id);
	}

	@Transactional
	public void insertUser(User user) {
		userDao.insertUser(user);
	}
	
	

}
