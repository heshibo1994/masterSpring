package com.smart.springboot06datajpa.controller;

import com.smart.springboot06datajpa.dao.UserDao;
import com.smart.springboot06datajpa.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    UserDao userDao;

    @GetMapping("/user/{id}")
    public User getName(@PathVariable("id") Integer id){
        User user = userDao.findById(id).orElse(new User());
        System.out.println(user);
        return user;
    }

    @GetMapping("/user")
    public User insertUser(User user){
        User save = userDao.save(user);
        return save;
    }


}
