package com.pong.blog.mapper;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pong.blog.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDAOTest {
	
	@Autowired
	private UserDAO userDAO;

	@Test
	public void testInsert() {
	}

	@Test
	public void testSelectByPrimaryKey() {
		User user=userDAO.selectByPrimaryKey(1l);
		
		System.out.println(user);
	}

	@Test
	public void testUpdateByPrimaryKey() {
	}

}
