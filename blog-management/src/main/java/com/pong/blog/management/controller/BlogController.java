package com.pong.blog.management.controller;


import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.pong.blog.dto.BlogDto;
import com.pong.blog.dto.BlogEdit;
import com.pong.blog.dto.BlogReslut;
import com.pong.blog.model.Post;

@Controller
public class BlogController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private RestTemplate restTemplate;

	@Value("${service.blog-url}")
	String serviceUrl;

	@RequestMapping(value = "/blog/index", method = RequestMethod.GET)
	public String index() {
		logger.info("blog 首页=======");
		return "blog/index";
	}

	@RequestMapping(value = "/blog/edit", method = RequestMethod.GET)
	public String editIndex(Long id, ModelMap map) {
		logger.info("edit index=======id:{}", id);
		Post post =new Post();
		if (id != null && id > 0) {
			Map<String, Object> uriVariables = new HashMap<String, Object>();
			uriVariables.put("id", id);
			post = restTemplate.getForObject(serviceUrl + "blog/get?id={id}", Post.class, uriVariables);
		}
		map.put("post", post);
		return "blog/edit";
	}

	@RequestMapping(value = "/blog/list", method = RequestMethod.GET)
	@ResponseBody
	public Object list(BlogDto dto) {
		logger.info("list======={}", dto);
		Map<String, Object> data = new HashMap<String, Object>();

		BlogReslut reslut = restTemplate.getForObject(serviceUrl + "blog/list?data={data}", BlogReslut.class,
				JSON.toJSONString(dto));

		data.put("draw", dto.getDraw());
		data.put("data", reslut.getPosts());
		data.put("recordsFiltered", reslut.getTotal());
		data.put("recordsTotal", reslut.getTotal());
		return data;
	}

	@RequestMapping(value = "/blog/edit", method = RequestMethod.POST)
	@ResponseBody
	public Object edit(BlogEdit edit) {
		logger.info("edit=======:{}", edit);
		Map<String, Object> data = new HashMap<String, Object>();

		int count = restTemplate.postForObject(serviceUrl + "blog/edit?data={data}", null, int.class,JSON.toJSONString(edit));

		data.put("result", count);
		return data;
	}
	
	@RequestMapping(value = "/blog/approve", method = RequestMethod.POST)
	@ResponseBody
	public Object approve(String data) {
		logger.info("approve=======:{}", data);
		Map<String, Object> result = new HashMap<String, Object>();

		int count = restTemplate.postForObject(serviceUrl + "blog/approve?data={data}", null, int.class,data);

		result.put("result", count);
		return result;
	}
	
	@RequestMapping(value = "/blog/delete", method = RequestMethod.POST)
	@ResponseBody
	public Object delete(String data) {
		logger.info("delete=======:{}", data);
		Map<String, Object> result = new HashMap<String, Object>();
		int count = restTemplate.postForObject(serviceUrl + "blog/delete?data={data}", null, int.class,data);
		result.put("result", count);
		return result;
	}
}
