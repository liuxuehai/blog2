package com.pong.blog.service.mapper;

import com.pong.blog.dto.BlogDto;
import com.pong.blog.model.Post;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface PostDAO {
    
    int insert(Post record);

    int updateByPrimaryKey(Post record);

	int count(BlogDto dto);

	List<Post> list(BlogDto dto);
	
	
	Post selectByPrimaryKey(Long id);

	int batchApprove(List<String> approve);
	
	int batchDelete(List<String> delete);
	
}