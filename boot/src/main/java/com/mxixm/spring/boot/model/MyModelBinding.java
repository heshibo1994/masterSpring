package com.mxixm.spring.boot.model;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MyModelBinding {
    @RequestMapping(path = "/modelMapModel")
    public String modelMapModeBinding(ModelMap modelMap){
        modelMap.put("date",new Date());
        modelMap.addAttribute("name","modelmap");
        return "defaultView";
    }

    @RequestMapping(path = "/modelAndViewModel")
    public ModelAndView modelAndViewModelBinding() {
        Map<String, Object> model = new HashMap<>(2);
        model.put("name", "ModelAndView类型");
        // 返回ModelAndView，第一个参数是视图名，第二个参数是模型。
        return new ModelAndView("defaultView", model);
    }
}
