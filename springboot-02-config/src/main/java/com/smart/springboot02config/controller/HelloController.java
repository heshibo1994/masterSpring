package com.smart.springboot02config.controller;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        return "hello world config";
    }
}
