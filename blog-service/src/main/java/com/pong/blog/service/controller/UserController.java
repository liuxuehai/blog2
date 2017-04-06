package com.pong.blog.service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pong.blog.model.User;
import com.pong.blog.service.mapper.UserDAO;

@RestController
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserDAO userDao;
	
	
	@GetMapping("/app/user/{id}")
	public User getUser(@PathVariable Long id) {
		logger.info("get info {}",id);
		return userDao.selectByPrimaryKey(id);
	}
}
