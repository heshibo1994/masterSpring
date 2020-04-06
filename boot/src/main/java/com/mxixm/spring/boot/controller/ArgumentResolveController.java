/**
 * 参数解析
 * */
package com.mxixm.spring.boot.controller;

import com.mxixm.spring.boot.domian.MyPostData;
import com.mxixm.spring.boot.domian.PersonData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ArgumentResolveController {
    /**
     * 路径变量
     * /user/1/topic/2
     * */
    @RequestMapping(path="user/{userId}/topic/{topicId}")
    public String topic(@PathVariable Integer userId,@PathVariable Integer topicId){
        System.out.println("userId: "+userId+" topicId: "+topicId);
        return "argumentView";
    }

    /**
     * 请求参数
     * /users?userId=66
     * */
    @GetMapping(path="users")
    public String findUserById(String userId){
        System.out.println("userId: "+userId);
        return "argumentView";
    }

    /**
     * 请求体
     * /users?userId=66
     * */
    @PostMapping(path="postData")
    public String postData(@Validated @RequestBody MyPostData myPostData,
    BindingResult result){
        System.out.println("校验数据是否有错误: "+result.hasErrors());
        System.out.println(myPostData);
        return "argumentView";
    }


    /**
     * 请求块
     * /users?userId=66
     * */
    @RequestMapping(path="multipartForm")
    public String multipartForm(){
        return "myMultipartFormView";
    }

    @RequestMapping(path="multipartFormSubmit")
    public String multipartFormSubmit(@RequestPart String firstName,
                                @RequestPart String lastName,
                                @RequestPart MultipartFile photo,Model model){
        model.addAttribute("fullName", firstName  + "." + lastName);
        return "myFormAgreedView";
    }

    /**
     * 模型属性
     * */
    @RequestMapping(path="modelAttribute/{name}")
    public String modelAttribute(@ModelAttribute PersonData data){
        return "myMultipartFormView";
    }
}
