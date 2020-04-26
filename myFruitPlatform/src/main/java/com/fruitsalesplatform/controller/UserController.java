package com.fruitsalesplatform.controller;

import com.fruitsalesplatform.entity.User;
import com.fruitsalesplatform.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class UserController extends BaseController {
    @Resource
    UserService userService;

    // 跳转到登录页面
    @RequestMapping("user/toLogin.action")
    public String toLogin(){
        return "/login.jsp";
    }

    // 跳转到登录页面
    @RequestMapping("user/login.action")
    public String Login(User user, Model model, HttpServletRequest request){
        Map<String,String> map = new HashMap<String,String>();
        map.put("username",user.getUserName());
        map.put("password",user.getPassword());
        List<User> userList = userService.find(map);
        if(userList!=null && userList.size()>0){
            request.getSession().setAttribute("user",userList.get(0));
            //转向主页
            return "/home.jsp";
        }else{
            model.addAttribute("errorMsg","登录失败，账号或者密码错误");
            // 转向登录页面
            return "/login.jsp";
        }
    }

    // 跳转到注册页面
    @RequestMapping("user/registerPage.action")
    public String toRegister(){
        return "/register.jsp";
    }

    // 后段注册
    @RequestMapping("user/register.action")
    public String register(User user, Model model, HttpServletRequest request, HttpServletResponse response){
        Map<String,String> map = new HashMap<String,String>();
        map.put("username",user.getUserName());
        List<User> userList = userService.find(map);
        if (userList!=null && userList.size()>0){
            model.addAttribute("errorMsg","该用户名已经被注册了");
            return "/register.jsp";//重新注册
        }
        user.setUserId(UUID.randomUUID().toString());
        userService.insert(user); //添加用户
        model.addAttribute("noticeMsg","注册成功");
        return "/login.jsp";//转向登录
    }



}
