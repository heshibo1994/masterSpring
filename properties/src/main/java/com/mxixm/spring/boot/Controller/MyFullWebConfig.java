package com.mxixm.spring.boot.Controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyFullWebConfig implements WebMvcConfigurer {
    public void configureAsyncSupport(AsyncSupportConfigurer configurer){
        configurer.setDefaultTimeout(30000);
    }

    public void addViewControllers(ViewControllerRegistry registry){
        // 添加重定向视图控制器，对于/路径的请求，重定向到/user下
        registry.addRedirectViewController("/","/user");
        // 添加视图控制器，对于/user/**模式的请求，直接使用视图/assets/index.html进行响应。
        registry.addViewController("/user/**").setViewName("/assets/index.html");
    }
}
