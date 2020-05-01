package com.smart.springboot04webrestfulcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class LoginController {

    @RequestMapping(value="/user/login",method = RequestMethod.POST)
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map){
        if(!StringUtils.isEmpty(username) && "123456".equals(password)){
            return "/dashboard";
        }else{
            map.put("msg","账号或者密码错误");
            return "/login";
        }

    }
}
