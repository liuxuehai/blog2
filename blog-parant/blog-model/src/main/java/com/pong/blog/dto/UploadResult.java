/*******************************************************************************
 * Created on 2017年5月11日 上午10:34:29
 * Copyright (c) 深圳市小牛在线互联网信息咨询有限公司版权所有. 粤ICP备13089339号
 * 注意：本内容仅限于深圳市小牛在线互联网信息咨询有限公司内部传阅，禁止外泄以及用于其他商业目的!
 ******************************************************************************/
package com.pong.blog.dto;

import com.blog.model.base.BaseObject;

/**
 * 
 * @since 1.0.0
 * @version  
 * @author liuping : 2017年5月11日 
 */
public class UploadResult extends BaseObject{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private String state;
    private String url;
    private String title;
    private String original;
    private String msg;
    /**
     * @return the state
     */
    public String getState() {
        return state;
    }
    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }
    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }
    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }
    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }
    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }
    /**
     * @return the original
     */
    public String getOriginal() {
        return original;
    }
    /**
     * @param original the original to set
     */
    public void setOriginal(String original) {
        this.original = original;
    }
    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }
    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }
    

}
