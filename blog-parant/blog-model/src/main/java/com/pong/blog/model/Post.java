package com.pong.blog.model;

import java.util.Date;

import com.blog.model.base.BaseObject;

public class Post extends BaseObject {
	private static final long serialVersionUID = 1L;

	private Long id;

	private Long author;
	
	private String tag;
	
	private String description;
	
	private String context;

    private String contextEng;

	private Date postDate;

	private Integer status;

	private Date postModified;

	private Long postParent;

	private String category;
	
	private String  title;

	private String guid;

	private String postType;

	private String postMimeType;

	private Long commentCount;

	private Date createTime;

	private Date updateTime;

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

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getPostModified() {
		return postModified;
	}

	public void setPostModified(Date postModified) {
		this.postModified = postModified;
	}

	public Long getPostParent() {
		return postParent;
	}

	public void setPostParent(Long postParent) {
		this.postParent = postParent;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category == null ? null : category.trim();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid == null ? null : guid.trim();
	}

	public String getPostType() {
		return postType;
	}

	public void setPostType(String postType) {
		this.postType = postType == null ? null : postType.trim();
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	/**
     * @return the contextEng
     */
    public String getContextEng() {
        return contextEng;
    }

    /**
     * @param contextEng the contextEng to set
     */
    public void setContextEng(String contextEng) {
        this.contextEng = contextEng;
    }

    public String getPostMimeType() {
		return postMimeType;
	}

	public void setPostMimeType(String postMimeType) {
		this.postMimeType = postMimeType == null ? null : postMimeType.trim();
	}

	public Long getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(Long commentCount) {
		this.commentCount = commentCount;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}