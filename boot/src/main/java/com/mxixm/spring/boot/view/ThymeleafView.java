package com.mxixm.spring.boot.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ThymeleafView {
    @RequestMapping("thymeleafView")
    public String thymeleafView(Model model){
        model.addAttribute("name","牛逼");
        model.addAttribute("sex","男");
        List<String> hobbies = new ArrayList<String>();
        hobbies.add("计算机");
        hobbies.add("英语");
        hobbies.add("数学");
        model.addAttribute("hobbies",hobbies);
        return "thymeLeafView";
    }
}
