package com.pong.blog.management.controller;


import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pong.blog.common.data.mongo.entity.Post;
import com.pong.blog.common.service.BlogPostService;
import com.pong.blog.dto.BlogDto;
import com.pong.blog.dto.BlogEdit;
import com.pong.blog.dto.BlogResult;
import com.pong.blog.management.data.mongo.PostContent;
import com.pong.blog.management.service.BlogService;
import com.pong.blog.management.support.nav.Navigation;
import com.pong.blog.management.support.nav.Section;

@Controller
@RequestMapping("/blog")
@Navigation(Section.BLOG)
public class BlogController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
//	@Autowired
//	private BlogService blogService;
	
	@Autowired
	private BlogPostService blogPostService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		logger.info("blog 首页=======");
		return "blog/index";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String editIndex(String id, ModelMap map) {
		logger.info("编辑基础信息 index=======id:{}", id);
		map.put("post", blogPostService.getPost(id));
		return "blog/edit";
	}
	
	@RequestMapping(value = "/chn", method = RequestMethod.GET)
    public String chnIndex(String id, ModelMap map) {
        logger.info("编辑中文文档 index=======id:{}", id);
        map.put("post", blogPostService.getPost(id));
        return "blog/chn";
    }
	
	@RequestMapping(value = "/eng", method = RequestMethod.GET)
    public String engIndex(String id, ModelMap map) {
        logger.info("编辑英文文档 index=======id:{}", id);
        map.put("post", blogPostService.getPost(id));
        return "blog/eng";
    }
	
	@RequestMapping(value = "/content", method = RequestMethod.POST)
    @ResponseBody
    public Object content(Post content) {
        logger.info("编辑文档=======:{}", content.getId());
        Map<String, Object> result = new HashMap<String, Object>();
        int count = blogPostService.editPostContext(content) ;
        result.put("result", count);
        return result;
    }

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public Object list(BlogDto dto) {
		logger.info("list======={}", dto);
		Map<String, Object> data = new HashMap<String, Object>();

//		BlogResult result = blogService.list(dto);
		
		Page<Post> posts=blogPostService.getPosts(dto.getStart(), dto.getLength());

		data.put("draw", dto.getDraw());
		data.put("data", posts.getContent());
		data.put("recordsFiltered", posts.getTotalElements());
		data.put("recordsTotal", posts.getTotalElements());
		return data;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseBody
	public Object edit(Post edit) {
		logger.info("编辑文档基本信息=======:{}", edit);
		Map<String, Object> data = new HashMap<String, Object>();

		int count = blogPostService.editPost(edit);
		data.put("result", count);
		return data;
	}
	
	@RequestMapping(value = "/approve", method = RequestMethod.POST)
	@ResponseBody
	public Object approve(String data) {
		logger.info("approve=======:{}", data);
		Map<String, Object> result = new HashMap<String, Object>();
		int count = blogPostService.updatePostStatus("2", data);//blogService.approve(data);
		result.put("result", count);
		return result;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public Object delete(String data) {
		logger.info("delete=======:{}", data);
		Map<String, Object> result = new HashMap<String, Object>();
		int count = blogPostService.updatePostStatus("3", data);;//blogService.delete(data);
		result.put("result", count);
		return result;
	}
}
