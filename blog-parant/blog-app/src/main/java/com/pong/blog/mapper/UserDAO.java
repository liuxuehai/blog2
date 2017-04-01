package com.pong.blog.mapper;

import com.pong.blog.model.User;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDAO {
	int insert(User record);

	User selectByPrimaryKey(Long id);

	int updateByPrimaryKey(User record);
}