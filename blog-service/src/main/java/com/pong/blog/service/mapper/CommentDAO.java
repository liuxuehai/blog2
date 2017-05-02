package com.pong.blog.service.mapper;

import com.pong.blog.model.Comment;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentDAO {
    int insert(Comment record);

    Comment selectByPrimaryKey(Long id);

    int updateByPrimaryKeyWithBLOBs(Comment record);

    int updateByPrimaryKey(Comment record);
}