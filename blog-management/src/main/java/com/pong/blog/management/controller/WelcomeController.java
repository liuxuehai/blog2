package com.pong.blog.management.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

	@GetMapping("/home")
	public String welcome(Map<String, Object> model) {
		return "home";
	}
}
