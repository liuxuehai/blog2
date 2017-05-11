/*******************************************************************************
 * Created on 2017年5月10日 上午11:10:35
 * Copyright (c) 深圳市小牛在线互联网信息咨询有限公司版权所有. 粤ICP备13089339号
 * 注意：本内容仅限于深圳市小牛在线互联网信息咨询有限公司内部传阅，禁止外泄以及用于其他商业目的!
 ******************************************************************************/
package com.pong.blog.management.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pong.blog.common.data.mongo.entity.Menu;
import com.pong.blog.common.service.MenuService;
import com.pong.blog.dto.BlogDto;
import com.pong.blog.management.support.nav.Navigation;
import com.pong.blog.management.support.nav.Section;

/**
 * 
 * @since 1.0.0
 * @version  
 * @author liuping : 2017年5月10日 
 */
@Controller
@RequestMapping("/menu")
@Navigation(Section.MENU)
public class MenuController {

    private Logger logger = LoggerFactory.getLogger(getClass());
    
    @Autowired
    private MenuService menuService;
    
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        logger.info("menu 首页=======");
        return "menu/index";
    }
    
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editIndex(String id, ModelMap map) {
        map.put("menu", menuService.getMenu(id));
        return "menu/edit";
    }
    
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public Object edit(Menu menu, ModelMap map) {
        Map<String, Object> result = new HashMap<String, Object>();
        int count = menuService.editMenu(menu);
        result.put("result", count);
        return result;
    }
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Object list(BlogDto dto) {
        logger.info("list======={}", dto);
        Map<String, Object> data = new HashMap<String, Object>();

        Page<Menu> menus=menuService.getMenus(dto.getStart(), dto.getLength());
        data.put("draw", dto.getDraw());
        data.put("data", menus.getContent());
        data.put("recordsFiltered", menus.getTotalElements());
        data.put("recordsTotal", menus.getTotalElements());
        return data;
    }
}
