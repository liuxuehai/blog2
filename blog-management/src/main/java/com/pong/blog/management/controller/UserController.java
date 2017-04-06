package com.pong.blog.management.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.pong.blog.model.User;

@RestController
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/app/user/{id}")
	public User findByIdByEurekaServer(@PathVariable Long id) {
		logger.info("get info {}",id);
		return restTemplate.getForEntity("http://blog.provider/app/user/" + id, User.class).getBody();
	}
}
