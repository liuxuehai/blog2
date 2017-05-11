/*******************************************************************************
 * Created on 2017年5月10日 上午10:34:54
 * Copyright (c) 深圳市小牛在线互联网信息咨询有限公司版权所有. 粤ICP备13089339号
 * 注意：本内容仅限于深圳市小牛在线互联网信息咨询有限公司内部传阅，禁止外泄以及用于其他商业目的!
 ******************************************************************************/
package com.pong.blog.common.data.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.pong.blog.common.data.mongo.entity.User;

/**
 * 
 * @since 1.0.0
 * @version  
 * @author liuping : 2017年5月10日 
 */
@Repository
public interface UserRepository extends MongoRepository<User, String> {
    
        User findByName(String name);
        
}
