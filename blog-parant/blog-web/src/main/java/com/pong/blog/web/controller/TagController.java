/*******************************************************************************
 * Created on 2017年5月12日 上午9:22:40
 * Copyright (c) 深圳市小牛在线互联网信息咨询有限公司版权所有. 粤ICP备13089339号
 * 注意：本内容仅限于深圳市小牛在线互联网信息咨询有限公司内部传阅，禁止外泄以及用于其他商业目的!
 ******************************************************************************/
package com.pong.blog.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pong.blog.common.data.mongo.entity.Post;
import com.pong.blog.common.service.BlogPostService;
import com.pong.blog.dto.TagDto;

/**
 * 
 * @since 1.0.0
 * @version  
 * @author liuping : 2017年5月12日 
 */
@Controller
@RequestMapping("/tag")
public class TagController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private BlogPostService blogPostService;

    @RequestMapping(value = { "/{tag}", "/index/{tag}" }, method = RequestMethod.GET)
    public String index(@PathVariable String tag, TagDto dto, ModelMap map) {
        logger.info("blog 首页=======", dto);

        Page<Post> posts = blogPostService.getPostsByTag(tag, dto.getStart(), dto.getLength());
        map.put("posts", posts.getContent());
        map.put("total", posts.getTotalElements());
        map.put("current", posts.getNumber());
        return "tag/index";
    }
}
