/*******************************************************************************
 * Created on 2017年5月10日 下午1:46:00
 * Copyright (c) 深圳市小牛在线互联网信息咨询有限公司版权所有. 粤ICP备13089339号
 * 注意：本内容仅限于深圳市小牛在线互联网信息咨询有限公司内部传阅，禁止外泄以及用于其他商业目的!
 ******************************************************************************/
package com.pong.blog.management.app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.UrlPathHelper;

import com.pong.blog.common.service.MenuService;
import com.pong.blog.management.support.nav.Navigation;

/**
 * 
 * @since 1.0.0
 * @version  
 * @author liuping : 2017年5月10日 
 */
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private MenuService menuService;
    
    @Bean(name = { "uih", "viewRenderingHelper" })
    @Scope("request")
    public ViewRenderingHelper viewRenderingHelper() {
        return new ViewRenderingHelper();
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HandlerInterceptorAdapter() {
            @Override
            public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                                   ModelAndView modelAndView) throws Exception {

                if (handler instanceof HandlerMethod) {
                    HandlerMethod handlerMethod = (HandlerMethod) handler;
                    Navigation navSection = handlerMethod.getBean().getClass().getAnnotation(Navigation.class);
                    if (navSection != null && modelAndView != null) {
                        modelAndView.addObject("navSection", navSection.value().toString().toLowerCase());
                        
                        modelAndView.addObject("menus", menuService.getAllMenu());
                    }
                }
            }
        });
    }

    static class ViewRenderingHelper {

        private final UrlPathHelper urlPathHelper = new UrlPathHelper();
        @Autowired
        private HttpServletRequest request;

        public String navClass(String active, String current) {
            if (active.equals(current)) {
                return "am-active";
            } else {
                return "";
            }
        }

        public String blogClass(String active, String current) {
            if (active.equals(current)) {
                return "blog-category active";
            } else {
                return "blog-category";
            }
        }

        public String path() {
            return urlPathHelper.getPathWithinApplication(request);
        }
    }
}
