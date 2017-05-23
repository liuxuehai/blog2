/*******************************************************************************
 * Created on 2017年5月23日 上午9:34:16
 * Copyright (c) 深圳市小牛在线互联网信息咨询有限公司版权所有. 粤ICP备13089339号
 * 注意：本内容仅限于深圳市小牛在线互联网信息咨询有限公司内部传阅，禁止外泄以及用于其他商业目的!
 ******************************************************************************/
package com.pong.blog.common.data.mongo.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;

/**
 * 
 * @since 1.0.0
 * @version  
 * @author liuping : 2017年5月23日 
 */
public class Comment {
    
    @Id
    private String id;
    
    private String postId;
    
    private String context;
    
    private String parentId;
    
    private Date date;
    
    private String userId;
    
    private int loveCount;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the postId
     */
    public String getPostId() {
        return postId;
    }

    /**
     * @param postId the postId to set
     */
    public void setPostId(String postId) {
        this.postId = postId;
    }

    /**
     * @return the context
     */
    public String getContext() {
        return context;
    }

    /**
     * @param context the context to set
     */
    public void setContext(String context) {
        this.context = context;
    }

    /**
     * @return the parentId
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * @param parentId the parentId to set
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return the loveCount
     */
    public int getLoveCount() {
        return loveCount;
    }

    /**
     * @param loveCount the loveCount to set
     */
    public void setLoveCount(int loveCount) {
        this.loveCount = loveCount;
    }

}
