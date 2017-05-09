package com.pong.blog.dto;

import com.blog.model.base.BasePage;

public class BlogDto extends BasePage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public  BlogDto() {
       this.setStart(0);
       this.setLength(10);
    }
}
