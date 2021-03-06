package com.pong.blog.management.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.pong.blog.common.data.mongo.entity.Menu;
import com.pong.blog.common.data.mongo.entity.User;
import com.pong.blog.common.service.UserService;
import com.pong.blog.dto.BlogDto;
import com.pong.blog.management.support.nav.Navigation;
import com.pong.blog.management.support.nav.Section;

@Controller
@RequestMapping("/user")
@Navigation(Section.USER)
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        logger.info("user 首页=======");
        return "user/index";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editIndex(String id, ModelMap map) {
        map.put("user", userService.getUser(id));
        return "user/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public Object edit(User user, ModelMap map) {
        Map<String, Object> result = new HashMap<String, Object>();
        int count = userService.editUser(user);
        result.put("result", count);
        return result;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Object list(BlogDto dto) {
        logger.info("list======={}", dto);
        Map<String, Object> data = new HashMap<String, Object>();

        Page<User> users = userService.getUsers(dto.getStart(), dto.getLength());
        data.put("draw", dto.getDraw());
        data.put("data", users.getContent());
        data.put("recordsFiltered", users.getTotalElements());
        data.put("recordsTotal", users.getTotalElements());
        return data;
    }

}
