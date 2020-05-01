package com.smart.springboot04webrestfulcrud.controller;


import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {
    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "hello World";
    }

    @RequestMapping("/login")
    public String index(){
        return "login";
    }

    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        map.put("name","<h1>可然/<h1>");
        map.put("users", Arrays.asList("z3","l4","w5"));
        return "success";
    }
}
