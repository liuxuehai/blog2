/*******************************************************************************
 * Created on 2017年5月8日 下午4:05:57
 * Copyright (c) 深圳市小牛在线互联网信息咨询有限公司版权所有. 粤ICP备13089339号
 * 注意：本内容仅限于深圳市小牛在线互联网信息咨询有限公司内部传阅，禁止外泄以及用于其他商业目的!
 ******************************************************************************/
package com.pong.blog.web.controller;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pong.blog.common.data.mongo.entity.Post;
import com.pong.blog.common.service.BlogPostService;
import com.pong.blog.common.service.CommentService;
import com.pong.blog.dto.BlogDto;

/**
 * 
 * @since 1.0.0
 * @version  
 * @author liuping : 2017年5月8日 
 */
@Controller
@RequestMapping("/blog")
public class BlogController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    // @Autowired
    // private BlogService blogService;
    @Autowired
    private BlogPostService blogPostService;
    @Autowired
    private CommentService commentService;

    @RequestMapping(value = { "", "/index" }, method = RequestMethod.GET)
    public String index(BlogDto dto, ModelMap map) {
        logger.info("blog 首页=======", dto);

        Page<Post> posts = blogPostService.getPostsByStatus("2", dto.getStart(), dto.getLength());
        map.put("posts", posts.getContent());
        map.put("total", posts.getTotalElements());
        map.put("current", posts.getNumber());
        return "blog/index";
    }

    @RequestMapping(value = "/article/{id}", method = RequestMethod.GET)
    public String article(@PathVariable String id, ModelMap map) {
        logger.info("article 信息=======id:{}", id);
        Post post = blogPostService.getPost(id);
        map.put("post", post);

        if (StringUtils.isNotBlank(post.getContext()) && StringUtils.isNotBlank(post.getContextEng())) {
            return "blog/article";
        }

        return "blog/article2";
    }

    @RequestMapping(value = "/author/{name}", method = RequestMethod.GET)
    public String author(@PathVariable String name, BlogDto dto, ModelMap map) {
        logger.info("author 信息=======id:{}", name);
        Page<Post> posts = blogPostService.getPostsByAuthor(name, dto.getStart(), dto.getLength());
        map.put("posts", posts.getContent());
        return "blog/index";
    }

    @RequestMapping(value = "/comment/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Object comment(@PathVariable String id, BlogDto dto) {
        return commentService.queryByPostId(id, dto.getStart(), dto.getLength());
    }
}
