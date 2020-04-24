package com.qfssc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {
    @RequestMapping("/student")

    public String student(){
        System.out.println("dsfdsfdsfdsfdsfsdfsdfsdfds");
        return "success";
    }
}