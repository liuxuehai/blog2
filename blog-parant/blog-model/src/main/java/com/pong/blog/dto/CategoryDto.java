/*******************************************************************************
 * Created on 2017年5月12日 上午9:26:53
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
public class CategoryDto extends BasePage {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String category;
    /**
     * 
     */
    public CategoryDto() {
        setStart(1);
        setLength(10);
    }
    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }
    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

}
