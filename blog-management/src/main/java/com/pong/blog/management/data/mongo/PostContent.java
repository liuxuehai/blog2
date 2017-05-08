/*******************************************************************************
 * Created on 2017年5月5日 下午3:45:08
 * Copyright (c) 深圳市小牛在线互联网信息咨询有限公司版权所有. 粤ICP备13089339号
 * 注意：本内容仅限于深圳市小牛在线互联网信息咨询有限公司内部传阅，禁止外泄以及用于其他商业目的!
 ******************************************************************************/
package com.pong.blog.management.data.mongo;

import org.springframework.data.annotation.Id;

import com.blog.model.base.BaseObject;

/**
 * 
 * @since 1.0.0
 * @version  
 * @author liuping : 2017年5月5日 
 */
public class PostContent {

    
    @Id
    private String id;
    
    private String context;

    private String contextEng;

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

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "PostContent [id=" + id + ", context=" + context + ", contextEng=" + contextEng + "]";
    }

}
