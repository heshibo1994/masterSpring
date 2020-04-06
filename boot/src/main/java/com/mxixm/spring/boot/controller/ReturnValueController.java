package com.mxixm.spring.boot.controller;

import com.mxixm.spring.boot.domian.MyData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class ReturnValueController {
    @GetMapping(path="myResponseBody")
    public MyData myResponseBody(){
        return getMyData();
    }
    @GetMapping(path="myModelAttributeReturn")
    @ModelAttribute("data")
    public MyData modelAttributeReturn(){
        return getMyData();
    }


    private  MyData getMyData(){
        MyData myData = new MyData();
        myData.setFirstName("123");
        myData.setLastName("234");
        return myData;

    }
}
