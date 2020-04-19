package com.mxixm.spring.boot.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ForwardViewController {
    @RequestMapping(value = "/forwardView",method = RequestMethod.GET)
    public String forwardViewController(Model model){
        model.addAttribute("info","转发前属性");
        return "forward:forwardTargetView";
    }

    @RequestMapping(path="forwardTargetView",method = RequestMethod.GET)
    public String forwardTargetView(HttpServletRequest request,Model model){
        Object first = request.getAttribute("info");
        model.addAttribute("first",first);
        model.addAttribute("second","转发后属性");
        return "viewView";

    }
}
