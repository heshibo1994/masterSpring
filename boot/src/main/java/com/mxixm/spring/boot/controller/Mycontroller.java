package com.mxixm.spring.boot.controller;


import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;


@Component("/myController")
public class Mycontroller implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        Map<String, Object> model = new HashMap<>(2);
        model.put("name","123");
        return new ModelAndView("defaultView",model);
    }
}
