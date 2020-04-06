package com.mxixm.spring.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class MyRequestMapping {
    @RequestMapping(path = "myRequestMapping",method = RequestMethod.GET)
    public String requestMappingGet(String name, Map<String,Object> model){
        model.put("name",name);
        return "defaultView";
    }
}
