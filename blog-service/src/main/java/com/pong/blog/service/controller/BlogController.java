package com.pong.blog.service.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import com.alibaba.fastjson.JSON;
import com.pong.blog.dto.BlogDto;
import com.pong.blog.dto.BlogEdit;
import com.pong.blog.dto.BlogReslut;
import com.pong.blog.model.Post;
import com.pong.blog.service.mapper.PostDAO;

@RestController
public class BlogController {

	private static final Logger logger = LoggerFactory.getLogger(BlogController.class);

	@Autowired
	PostDAO postDAO;

	@RequestMapping(value = "/blog/list", method = { GET })
	public BlogReslut list(String data) {
		logger.info("list请求数据:{}", data);

		BlogDto dto = JSON.parseObject(data, BlogDto.class);
		BlogReslut result = new BlogReslut();
		int count = postDAO.count(dto);
		if (count > 0) {
			List<Post> list = postDAO.list(dto);
			if (CollectionUtils.isNotEmpty(list)) {
				result.setPosts(list);
				result.setTotal(list.size());
			}
		}
		logger.info("反馈posts信息:{}", result);
		return result;
	}

	@RequestMapping(value = "/blog/edit", method = { POST })
	public int edit(String data) {
		logger.info("edit请求数据:{}", data);
		if (StringUtils.isEmpty(data)) {
			return 0;
		}

		BlogEdit edit = JSON.parseObject(data, BlogEdit.class);
		if (edit == null) {
			return 0;
		}

		Post post = new Post();
		BeanUtils.copyProperties(edit, post);
		int result = 0;
		if (post != null && post.getId() != null && post.getId() > 0) {
			result = postDAO.updateByPrimaryKey(post);
		} else {
			post.setCommentCount(0l);
			post.setPostDate(new Date());
			post.setStatus(0);//未发布
			result = postDAO.insert(post);
		}
		
		logger.info("edit反馈数据:{}", result);
		return result;
	}

	@RequestMapping(value = "/blog/get", method = { GET })
	public Post get(Long id) {
		logger.info("获取post信息id:{}", id);
		if (id == null || id <= 0) {
			return null;
		}
		return postDAO.selectByPrimaryKey(id);
	}
	
	@RequestMapping(value = "/blog/approve", method = { POST })
	public int approve(String data) {
		logger.info("approve 请求数据:{}", data);
		int result = 0;
		if (StringUtils.isEmpty(data)) {
			return result;
		}
		
		List <String> approve=Arrays.asList(data.split(","));
		result=postDAO.batchApprove(approve);
		
		return result;
	}
	
	@RequestMapping(value = "/blog/delete", method = { POST })
	public int delete(String data) {
		logger.info("delete 请求数据:{}", data);
		int result = 0;
		if (StringUtils.isEmpty(data)) {
			return result;
		}
		
		List <String> delete=Arrays.asList(data.split(","));
		result=postDAO.batchDelete(delete);
		
		return result;
	}
}
