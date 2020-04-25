package com.fruitsalesplatform.controller;

import com.fruitsalesplatform.entity.User;
import com.fruitsalesplatform.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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



}
