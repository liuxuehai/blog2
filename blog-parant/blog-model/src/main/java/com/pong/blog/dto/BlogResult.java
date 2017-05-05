package com.pong.blog.dto;

import java.util.ArrayList;
import java.util.List;

import com.blog.model.base.BaseObject;
import com.pong.blog.model.Post;

public class BlogResult extends BaseObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int total;
	private List<Post> posts;

	public BlogResult() {
		total = 0;
		posts = new ArrayList<Post>();
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

}
