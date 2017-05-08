package com.pong.blog.web.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import nz.net.ultraq.thymeleaf.LayoutDialect;

@Configuration
public class ThymleafConfiguration {

	@Bean
	public LayoutDialect layoutDialect() {
		return new LayoutDialect();
	}
}
