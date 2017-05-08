package com.pong.blog.management.controller;


import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pong.blog.dto.BlogDto;
import com.pong.blog.dto.BlogEdit;
import com.pong.blog.dto.BlogResult;
import com.pong.blog.management.data.mongo.PostContent;
import com.pong.blog.management.service.BlogService;

@Controller
public class BlogController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private BlogService blogService;

	@RequestMapping(value = "/blog/index", method = RequestMethod.GET)
	public String index() {
		logger.info("blog 首页=======");
		return "blog/index";
	}

	@RequestMapping(value = "/blog/edit", method = RequestMethod.GET)
	public String editIndex(Long id, ModelMap map) {
		logger.info("编辑基础信息 index=======id:{}", id);
		map.put("post", blogService.getPost(id));
		return "blog/edit";
	}
	
	@RequestMapping(value = "/blog/chn", method = RequestMethod.GET)
    public String chnIndex(Long id, ModelMap map) {
        logger.info("编辑中文文档 index=======id:{}", id);
        map.put("post", blogService.getPost(id));
        return "blog/chn";
    }
	
	@RequestMapping(value = "/blog/eng", method = RequestMethod.GET)
    public String engIndex(Long id, ModelMap map) {
        logger.info("编辑英文文档 index=======id:{}", id);
        map.put("post", blogService.getPost(id));
        return "blog/eng";
    }
	
	@RequestMapping(value = "/blog/content", method = RequestMethod.POST)
    @ResponseBody
    public Object content(PostContent content) {
        logger.info("编辑文档=======:{}", content.getId());
        Map<String, Object> result = new HashMap<String, Object>();
        int count = blogService.editContent(content);
        result.put("result", count);
        return result;
    }

	@RequestMapping(value = "/blog/list", method = RequestMethod.GET)
	@ResponseBody
	public Object list(BlogDto dto) {
		logger.info("list======={}", dto);
		Map<String, Object> data = new HashMap<String, Object>();

		BlogResult result = blogService.list(dto);

		data.put("draw", dto.getDraw());
		data.put("data", result.getPosts());
		data.put("recordsFiltered", result.getTotal());
		data.put("recordsTotal", result.getTotal());
		return data;
	}

	@RequestMapping(value = "/blog/edit", method = RequestMethod.POST)
	@ResponseBody
	public Object edit(BlogEdit edit) {
		logger.info("编辑文档基本信息=======:{}", edit);
		Map<String, Object> data = new HashMap<String, Object>();

		int count = blogService.editPost(edit);
		data.put("result", count);
		return data;
	}
	
	@RequestMapping(value = "/blog/approve", method = RequestMethod.POST)
	@ResponseBody
	public Object approve(String data) {
		logger.info("approve=======:{}", data);
		Map<String, Object> result = new HashMap<String, Object>();
		int count = blogService.approve(data);
		result.put("result", count);
		return result;
	}
	
	@RequestMapping(value = "/blog/delete", method = RequestMethod.POST)
	@ResponseBody
	public Object delete(String data) {
		logger.info("delete=======:{}", data);
		Map<String, Object> result = new HashMap<String, Object>();
		int count = blogService.delete(data);
		result.put("result", count);
		return result;
	}
}
