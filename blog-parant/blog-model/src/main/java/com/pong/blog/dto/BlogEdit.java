package com.pong.blog.dto;

import com.blog.model.base.BaseObject;

public class BlogEdit extends BaseObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long  id;
	private Long  author;
	private String title;
	private String category;
	private String tag;
	private String context;
	private String contextEng;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getAuthor() {
		return author;
	}
	public void setAuthor(Long author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	/**
     * @return the tag
     */
    public String getTag() {
        return tag;
    }
    /**
     * @param tag the tag to set
     */
    public void setTag(String tag) {
        this.tag = tag;
    }
    public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getContextEng() {
		return contextEng;
	}
	public void setContextEng(String contextEng) {
		this.contextEng = contextEng;
	}
	

}
