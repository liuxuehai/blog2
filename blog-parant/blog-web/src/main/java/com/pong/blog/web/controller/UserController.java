/*******************************************************************************
 * Created on 2017年5月11日 下午3:59:12
 * Copyright (c) 深圳市小牛在线互联网信息咨询有限公司版权所有. 粤ICP备13089339号
 * 注意：本内容仅限于深圳市小牛在线互联网信息咨询有限公司内部传阅，禁止外泄以及用于其他商业目的!
 ******************************************************************************/
package com.pong.blog.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pong.blog.common.data.mongo.entity.User;
import com.pong.blog.common.service.UserService;
import com.pong.blog.dto.BlogDto;

/**
 * 
 * @since 1.0.0
 * @version  
 * @author liuping : 2017年5月11日 
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/author/{name}", method = RequestMethod.GET)
    public String author(@PathVariable String name, BlogDto dto, ModelMap map) {
        User user = userService.findByName(name);
        map.put("user", user);
        return "user/index";
    }
}
