package com.pong.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pong.blog.mapper.UserDAO;
import com.pong.blog.model.User;

@RestController
public class UserController {
	
	@Autowired
	UserDAO userDao;
	
	
	@GetMapping("/app/user/{id}")
	public User getUser(@PathVariable Long id) {
		return userDao.selectByPrimaryKey(id);
	}
}
