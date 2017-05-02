package com.pong.blog.management.app;

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
