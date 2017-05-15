/*******************************************************************************
 * Created on 2017年5月12日 上午9:25:34
 * Copyright (c) 深圳市小牛在线互联网信息咨询有限公司版权所有. 粤ICP备13089339号
 * 注意：本内容仅限于深圳市小牛在线互联网信息咨询有限公司内部传阅，禁止外泄以及用于其他商业目的!
 ******************************************************************************/
package com.pong.blog.dto;

import com.blog.model.base.BasePage;

/**
 * 
 * @since 1.0.0
 * @version  
 * @author liuping : 2017年5月12日 
 */
public class TagDto extends BasePage {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String tag;
    /**
     * 
     */
    public TagDto() {
        setStart(1);
        setLength(10);
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

}
