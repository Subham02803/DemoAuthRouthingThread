package com.example.DemoAuthRouthingThread.threadtest.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DemoAuthRouthingThread.threadtest.dao.UserDao;
import com.example.DemoAuthRouthingThread.threadtest.model.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;

	Logger log = LoggerFactory.getLogger(UserService.class);
	
	public List<User> getAllUsers(){
		log.info("in getAllUsers Service by " + Thread.currentThread().getName());
		return userDao.findAll();
	}
	
	public List<User> saveUsers(List<User> users){
		log.info("in saveUsers Service by " + Thread.currentThread().getName());
		return userDao.saveAll(users);
	}
}
