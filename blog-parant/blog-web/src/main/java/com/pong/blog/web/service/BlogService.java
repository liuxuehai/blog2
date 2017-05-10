/*******************************************************************************
 * Created on 2017年5月8日 下午4:07:03
 * Copyright (c) 深圳市小牛在线互联网信息咨询有限公司版权所有. 粤ICP备13089339号
 * 注意：本内容仅限于深圳市小牛在线互联网信息咨询有限公司内部传阅，禁止外泄以及用于其他商业目的!
 ******************************************************************************/
package com.pong.blog.web.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.pong.blog.dto.BlogDto;
import com.pong.blog.dto.BlogResult;
import com.pong.blog.model.Post;
import com.pong.blog.web.data.mongo.PostContent;
import com.pong.blog.web.data.mongo.PostContentRepository;


/**
 * 
 * @since 1.0.0
 * @version  
 * @author liuping : 2017年5月8日 
 */
//@Service
public class BlogService {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private PostContentRepository postContentRepository;
    @Value("${service.blog-url}")
    String serviceUrl;
    
    
    public BlogResult list(BlogDto dto) {
        logger.info("条件查询post信息=======dto:{}", dto);
        BlogResult result=restTemplate.getForObject(serviceUrl + "blog/list?data={data}", BlogResult.class,
                JSON.toJSONString(dto));
        if(result.getPosts()!=null&&result.getPosts().size()>0){
            for (Post post : result.getPosts()) {
                PostContent temp=postContentRepository.findOne(post.getId().toString());
                if(temp!=null){
                    post.setDescription(temp.getDescription());
                }
            }
        }
        
        return result;
    }
    
    public Post getPost(String id) {
        logger.info("获取post信息=======id:{}", id);
        Post post = new Post();
        if (StringUtils.isNoneBlank(id)) {
            Map<String, Object> uriVariables = new HashMap<String, Object>();
            uriVariables.put("id", id);
            post = restTemplate.getForObject(serviceUrl + "blog/get?id={id}", Post.class, uriVariables);
            PostContent temp = postContentRepository.findOne(id);
            if(temp!=null){
                post.setContext(temp.getContext());
                post.setContextEng(temp.getContextEng());
                post.setDescription(temp.getDescription());
            }
            
        }
        logger.info("反馈post信息=======post:{}", post);
        return post;
    }
    
}
