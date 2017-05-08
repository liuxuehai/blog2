/*******************************************************************************
 * Created on 2017年5月8日 下午4:05:57
 * Copyright (c) 深圳市小牛在线互联网信息咨询有限公司版权所有. 粤ICP备13089339号
 * 注意：本内容仅限于深圳市小牛在线互联网信息咨询有限公司内部传阅，禁止外泄以及用于其他商业目的!
 ******************************************************************************/
package com.pong.blog.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pong.blog.web.service.BlogService;


/**
 * 
 * @since 1.0.0
 * @version  
 * @author liuping : 2017年5月8日 
 */
@Controller
public class BlogController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private BlogService blogService;
    
    
    @RequestMapping(value = "/blog/index", method = RequestMethod.GET)
    public String index() {
        logger.info("blog 首页=======");
        return "blog/index";
    }
    
    
    
}
