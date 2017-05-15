/*******************************************************************************
 * Created on 2017年5月12日 下午3:19:41
 * Copyright (c) 深圳市小牛在线互联网信息咨询有限公司版权所有. 粤ICP备13089339号
 * 注意：本内容仅限于深圳市小牛在线互联网信息咨询有限公司内部传阅，禁止外泄以及用于其他商业目的!
 ******************************************************************************/
package com.pong.blog.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @since 1.0.0
 * @version  
 * @author liuping : 2017年5月12日 
 */
@Controller
@RequestMapping("/about")
public class AboutController {
    
    private Logger logger = LoggerFactory.getLogger(getClass());



    @RequestMapping(value = {"","/index"}, method = RequestMethod.GET)
    public String index(ModelMap map) {
        
        return "about/index";
    }
}
