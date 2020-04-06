package com.mxixm.spring.boot.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DebugController {

    @GetMapping("/debug")
    public String debug(){
        int sum = 0;
        for(int a = 0;a<10;a++){
            sum+=a;
        }
        return "debugView";
    }
}
