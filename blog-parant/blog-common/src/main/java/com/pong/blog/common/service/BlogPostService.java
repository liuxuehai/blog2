/*******************************************************************************
 * Created on 2017年5月9日 下午6:11:04
 * Copyright (c) 深圳市小牛在线互联网信息咨询有限公司版权所有. 粤ICP备13089339号
 * 注意：本内容仅限于深圳市小牛在线互联网信息咨询有限公司内部传阅，禁止外泄以及用于其他商业目的!
 ******************************************************************************/
package com.pong.blog.common.service;

import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.mongodb.WriteResult;
import com.pong.blog.common.data.mongo.entity.Post;
import com.pong.blog.common.data.mongo.repository.PostRepository;

/**
 * 
 * @since 1.0.0
 * @version  
 * @author liuping : 2017年5月9日 
 */
@Service
public class BlogPostService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public Post getPost(String id) {
        logger.info("获取post信息 ===== id:{}", id);
        Post post = new Post();
        if (StringUtils.isNotBlank(id)) {
            post = postRepository.findOne(id);
        }

        return post;
    }

    public int editPost(Post post) {
        if (post == null) {
            return 0;
        }
        post.setStatus("1");// 未审核
        post.setPostDate(new Date());
        post.setAuthor("liuping");
        if (StringUtils.isBlank(post.getId())) {
            post.setId(UUID.randomUUID().toString());
        } else {
            Post temp = postRepository.findOne(post.getId());
            if (temp != null) {
                if (StringUtils.isNoneBlank(temp.getDescription())) {
                    post.setDescription(temp.getDescription());
                }

                if (StringUtils.isNoneBlank(temp.getContext())) {
                    post.setContext(temp.getContext());
                }
                if (StringUtils.isNoneBlank(temp.getContextEng())) {
                    post.setContextEng(temp.getContextEng());
                }
            }
        }

        postRepository.save(post);

        return 1;
    }

    public int editPostContext(Post post) {
        if (post == null || StringUtils.isBlank(post.getId())) {
            return 0;
        }
        Post temp = postRepository.findOne(post.getId());
        if (temp != null) {
            if (StringUtils.isNoneBlank(post.getDescription())) {
                temp.setDescription(post.getDescription());
            }

            if (StringUtils.isNoneBlank(post.getContext())) {
                temp.setContext(post.getContext());
            }
            if (StringUtils.isNoneBlank(post.getContextEng())) {
                temp.setContextEng(post.getContextEng());
            }

            postRepository.save(temp);

        } else {
            return 0;
        }

        return 1;
    }

    public Page<Post> getPostsByStatus(String status, int pageNumber, int pageSize) {

        PageRequest request = new PageRequest(pageNumber-1, pageSize, null);
        Page<Post> posts = postRepository.queryByStatus(status, request);
        return posts;
    }
    
    public Page<Post> getPostsByAuthor(String author, int pageNumber, int pageSize) {

        PageRequest request = new PageRequest(pageNumber, pageSize, null);
        Page<Post> posts = postRepository.queryByAuthor(author, request);
        return posts;
    }

    public Page<Post> getPosts(int pageNumber, int pageSize) {
        PageRequest request = new PageRequest(pageNumber, pageSize, null);
        Page<Post> posts = postRepository.findAll(request);
        return posts;
    }

    public int updatePostStatus(String status, String id) {

        WriteResult result = mongoTemplate.updateMulti(
                new Query(Criteria.where("_id").in(Arrays.asList(id.split(",")))),
                new Update().set("status", status), "post");
        return result.getN();
    }

}
