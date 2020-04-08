package com.smart.web;

import com.smart.cons.CommonConstant;
import com.smart.domain.User;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;

public class BaseController {
    protected static final String ERROR_MSG_KEY = "errorMsg";

    // 获取Session中的用户对象
    protected User getSessionUser(HttpServletRequest request){
        return (User)request.getSession().getAttribute(CommonConstant.USER_CONTEXT);
    }
    // 将用户保存在Session中
    protected void setSessionUser(HttpServletRequest request,User user){
        request.getSession().setAttribute(CommonConstant.USER_CONTEXT,user);
    }

    // 获取基于应用程序的URL
    protected final String getAppbaseUrl (HttpServletRequest request,String url){
        Assert.hasText(url,"URL不能为空");
        Assert.isTrue(url.startsWith("/"),"URL必须以/开头");
        return request.getContextPath() +url;
    }



}
