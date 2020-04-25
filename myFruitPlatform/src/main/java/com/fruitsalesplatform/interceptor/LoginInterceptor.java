package com.fruitsalesplatform.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    // 添加登录检测
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        if (!(uri.contains("Login") || uri.contains("login") || uri.contains("register"))){
            // 非登陆请求
            if (request.getSession().getAttribute("user")!=null){
                return true;//已经正常登录，直接放行
            }else{
                if(uri.contains("css")||uri.contains("js")||uri.contains("images")){
                    return true;//静态资源请求，可以放行
                }else{
                    //没有登录，跳转到登录界面
                    response.sendRedirect(request.getContextPath()+"/user/toLogin.action");
                }
            }
        }
        else{
            // 登录请求
            return true;
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
