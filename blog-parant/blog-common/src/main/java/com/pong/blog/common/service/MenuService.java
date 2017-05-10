/*******************************************************************************
 * Created on 2017年5月10日 上午11:14:42
 * Copyright (c) 深圳市小牛在线互联网信息咨询有限公司版权所有. 粤ICP备13089339号
 * 注意：本内容仅限于深圳市小牛在线互联网信息咨询有限公司内部传阅，禁止外泄以及用于其他商业目的!
 ******************************************************************************/
package com.pong.blog.common.service;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.pong.blog.common.data.mongo.entity.Menu;
import com.pong.blog.common.data.mongo.repository.MenuRepository;

/**
 * 
 * @since 1.0.0
 * @version  
 * @author liuping : 2017年5月10日 
 */
@Service
public class MenuService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MenuRepository menuRepository;

    public Menu getMenu(String id) {
        Menu menu = new Menu();
        if (StringUtils.isNotBlank(id)) {
            menu = menuRepository.findOne(id);
        }
        return menu;
    }

    public int editMenu(Menu menu) {
        if (menu == null) {
            return 0;
        }

        if (StringUtils.isBlank(menu.getId())) {
            menu.setId(UUID.randomUUID().toString());
        }
        menuRepository.save(menu);
        return 1;
    }

    public Page<Menu> getMenus(int pageNumber, int pageSize) {
        PageRequest request = new PageRequest(pageNumber, pageSize, null);
        Page<Menu> menus = menuRepository.findAll(request);
        return menus;
    }

    public List<Menu> getAllMenu() {
        return menuRepository.findAll();
    }
}
