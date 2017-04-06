package com.pong.blog.consumer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@GetMapping("/blog/index")
	public String index() {
		logger.info("首页=======");
		return "blog/44";
	}
}
