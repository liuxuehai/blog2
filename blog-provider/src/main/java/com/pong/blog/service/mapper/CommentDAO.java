package com.pong.blog.service.mapper;

import com.pong.blog.model.Comment;

import org.apache.ibatis.annotations.Mapper;

@Mapper 
public interface CommentDAO {
    int insert(Comment record);

    Comment selectByPrimaryKey(Long id);

    int updateByPrimaryKeyWithBLOBs(Comment record);

    int updateByPrimaryKey(Comment record);
}