/*******************************************************************************
 * Created on 2017年5月23日 上午9:39:53
 * Copyright (c) 深圳市小牛在线互联网信息咨询有限公司版权所有. 粤ICP备13089339号
 * 注意：本内容仅限于深圳市小牛在线互联网信息咨询有限公司内部传阅，禁止外泄以及用于其他商业目的!
 ******************************************************************************/
package com.pong.blog.common.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.pong.blog.common.data.mongo.entity.Comment;
import com.pong.blog.common.data.mongo.repository.CommentRepository;

/**
 * 
 * @since 1.0.0
 * @version  
 * @author liuping : 2017年5月23日 
 */
@Service
public class CommentService {
    
    private Logger logger = LoggerFactory.getLogger(getClass());
    
    @Autowired
    private CommentRepository commentRepository;
    
    
    public Page<Comment> queryByPostId(String postId, int pageNumber, int pageSize){
        PageRequest request = new PageRequest(pageNumber - 1, pageSize, null);
        
        return commentRepository.queryByPostId(postId, request);
    }

}
