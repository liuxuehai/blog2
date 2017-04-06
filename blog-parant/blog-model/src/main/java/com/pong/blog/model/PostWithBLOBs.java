package com.pong.blog.model;

public class PostWithBLOBs extends Post {
	private static final long serialVersionUID = 1L;

	private String postContext;

	private String postConextEng;

	private String postTitle;

	public String getPostContext() {
		return postContext;
	}

	public void setPostContext(String postContext) {
		this.postContext = postContext == null ? null : postContext.trim();
	}

	public String getPostConextEng() {
		return postConextEng;
	}

	public void setPostConextEng(String postConextEng) {
		this.postConextEng = postConextEng == null ? null : postConextEng.trim();
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle == null ? null : postTitle.trim();
	}
}