/*******************************************************************************
 * Created on 2017年5月10日 下午4:12:41
 * Copyright (c) 深圳市小牛在线互联网信息咨询有限公司版权所有. 粤ICP备13089339号
 * 注意：本内容仅限于深圳市小牛在线互联网信息咨询有限公司内部传阅，禁止外泄以及用于其他商业目的!
 ******************************************************************************/
package com.pong.blog.common.data.mongo.entity;

import org.springframework.data.annotation.Id;

/**
 * 
 * @since 1.0.0
 * @version  
 * @author liuping : 2017年5月10日 
 */
public class User {
    @Id
    private String id;
    private String name;
    private String password;
    private String role;
    private String email;
    private String phone;
    private String qq;
    private String github;
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }
    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * @return the role
     */
    public String getRole() {
        return role;
    }
    /**
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }
    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }
    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }
    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
    /**
     * @return the qq
     */
    public String getQq() {
        return qq;
    }
    /**
     * @param qq the qq to set
     */
    public void setQq(String qq) {
        this.qq = qq;
    }
    /**
     * @return the github
     */
    public String getGithub() {
        return github;
    }
    /**
     * @param github the github to set
     */
    public void setGithub(String github) {
        this.github = github;
    }
    
    
}
