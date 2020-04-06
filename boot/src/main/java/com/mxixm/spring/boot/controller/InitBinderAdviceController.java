package com.mxixm.spring.boot.controller;

import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class InitBinderAdviceController {
    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));
    }

    @GetMapping("initBinderAdvice")
    public String initBinderAdvice(Date date){
        System.out.println(date);
        return date.toString();
    }
}
