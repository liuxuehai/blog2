/*******************************************************************************
 * Created on 2017年5月10日 下午4:16:24
 * Copyright (c) 深圳市小牛在线互联网信息咨询有限公司版权所有. 粤ICP备13089339号
 * 注意：本内容仅限于深圳市小牛在线互联网信息咨询有限公司内部传阅，禁止外泄以及用于其他商业目的!
 ******************************************************************************/
package com.pong.blog.common.service;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.pong.blog.common.data.mongo.entity.Menu;
import com.pong.blog.common.data.mongo.entity.User;
import com.pong.blog.common.data.mongo.repository.UserRepository;

/**
 * 
 * @since 1.0.0
 * @version  
 * @author liuping : 2017年5月10日 
 */
@Service
public class UserService {
    
    private Logger logger = LoggerFactory.getLogger(getClass());
 
    @Autowired
    private UserRepository userRepository;
    
    
    public int editUser(User user){
        if (user == null) {
            return 0;
        }

        if (StringUtils.isBlank(user.getId())) {
            user.setId(UUID.randomUUID().toString());
        }
        userRepository.save(user);
        return 1;
    }
    
    
    public User getUserByPhone(String phone){
        return userRepository.findOne(phone);
    }

    public Page<User> getUsers(int pageNumber, int pageSize) {
        PageRequest request = new PageRequest(pageNumber, pageSize, null);
        Page<User> users = userRepository.findAll(request);
        return users;
    }
    /**
     * 
     * @param id
     * @return
     *
     * @author liuping 2017年5月10日 下午4:29:19
     */
    public User getUser(String id) {
        User user=new User();
        if (StringUtils.isNotBlank(id)) {
            user=userRepository.findOne(id);
        }
        return user;
    }
    
}
