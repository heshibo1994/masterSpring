package com.fruitsalesplatform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RetailerController extends BaseController {
    @RequestMapping("/retailer/list.action")
    public String list(){
        return "home.jsp";
    }
}
