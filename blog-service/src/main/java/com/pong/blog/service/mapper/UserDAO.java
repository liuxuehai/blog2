package com.pong.blog.service.mapper;

import com.pong.blog.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO {
    int insert(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKey(User record);
}