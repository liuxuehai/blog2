/*******************************************************************************
 * Created on 2017年5月5日 下午3:55:07
 * Copyright (c) 深圳市小牛在线互联网信息咨询有限公司版权所有. 粤ICP备13089339号
 * 注意：本内容仅限于深圳市小牛在线互联网信息咨询有限公司内部传阅，禁止外泄以及用于其他商业目的!
 ******************************************************************************/
package com.pong.blog.management.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.pong.blog.dto.BlogDto;
import com.pong.blog.dto.BlogEdit;
import com.pong.blog.dto.BlogResult;
import com.pong.blog.management.data.mongo.PostContent;
import com.pong.blog.management.data.mongo.PostContentRepository;
import com.pong.blog.model.Post;

/**
 * 
 * @since 1.0.0
 * @version  
 * @author liuping : 2017年5月5日 
 */
@Service
public class BlogService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RestTemplate restTemplate;
//    @Autowired
//    private PostContentRepository postContentRepository;
    @Autowired
    private  MongoTemplate mongoTemplate;

    @Value("${service.blog-url}")
    String serviceUrl;

    public Post getPost(Long id) {
        logger.info("获取post信息=======id:{}", id);
        Post post = new Post();
        if (id != null && id > 0) {
            Map<String, Object> uriVariables = new HashMap<String, Object>();
            uriVariables.put("id", id);
            post = restTemplate.getForObject(serviceUrl + "blog/get?id={id}", Post.class, uriVariables);
            PostContent temp = mongoTemplate.findById(id.toString(), PostContent.class);
            if(temp!=null){
                post.setContext(temp.getContext());
                post.setContextEng(temp.getContextEng());
            }
            
        }
        logger.info("反馈post信息=======post:{}", post);
        return post;
    }

    public BlogResult list(BlogDto dto) {
        logger.info("条件查询post信息=======dto:{}", dto);
        return restTemplate.getForObject(serviceUrl + "blog/list?data={data}", BlogResult.class,
                JSON.toJSONString(dto));
    }

    public int editPost(BlogEdit data) {
        logger.info("编辑post信息=======data:{}", data);
        return restTemplate.postForObject(serviceUrl + "blog/edit?data={data}", null, int.class,
                JSON.toJSONString(data));
    }

    public int editContent(PostContent content) {
        logger.info("编辑post content 信息=======content:{}", content.getId());
        int result = 0;
        if (content == null || StringUtils.isBlank(content.getId())) {
            return result;
        }
        
//        PostContent temp = postContentRepository.findOne(content.getId());
        PostContent temp = mongoTemplate.findById(content.getId(), PostContent.class);

        PostContent postContent = new PostContent();
        postContent.setId(content.getId());
        if (StringUtils.isNotBlank(content.getContext())) {
            postContent.setContext(content.getContext());
            if(temp!=null){
                postContent.setContextEng(temp.getContextEng());
            }
            
        }

        if (StringUtils.isNotBlank(content.getContextEng())) {
            postContent.setContextEng(content.getContextEng());
            if(temp!=null){
               postContent.setContext(temp.getContext());
            }
        }
        
        mongoTemplate.save(postContent);
//        postContentRepository.save(postContent);

        return 1;
    }

    public int approve(String data) {
        logger.info("approve post信息=======data:{}", data);
        return restTemplate.postForObject(serviceUrl + "blog/approve?data={data}", null, int.class, data);
    }

    public int delete(String data) {
        logger.info("delete post信息=======data:{}", data);
        return restTemplate.postForObject(serviceUrl + "blog/delete?data={data}", null, int.class, data);
    }

}
