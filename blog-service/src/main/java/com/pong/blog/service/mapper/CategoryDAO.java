package com.pong.blog.service.mapper;

import com.pong.blog.model.Category;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDAO {
    int insert(Category record);

    Category selectByPrimaryKey(Long id);

    int updateByPrimaryKey(Category record);
}