package com.pong.blog.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.pong.blog.mapper.UserDAO;
import com.pong.blog.model.User;

@SpringBootApplication
@ComponentScan(basePackages = "com.pong.blog.service")
public class BlogApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BlogApplication.class, args);
		UserDAO userDao=context.getBean(UserDAO.class);
		User user=userDao.selectByPrimaryKey(0l);
		System.out.println(user);
	}
}
