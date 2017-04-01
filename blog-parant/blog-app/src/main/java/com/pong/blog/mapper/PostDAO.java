package com.pong.blog.mapper;

import com.pong.blog.model.Post;
import com.pong.blog.model.PostWithBLOBs;

import org.apache.ibatis.annotations.Mapper;

@Mapper 
public interface PostDAO {
    int insert(PostWithBLOBs record);

    PostWithBLOBs selectByPrimaryKey(Long id);

    int updateByPrimaryKeyWithBLOBs(PostWithBLOBs record);

    int updateByPrimaryKey(Post record);
}