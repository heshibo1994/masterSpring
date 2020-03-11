package com.smart.service;

import com.smart.dao.LoginLogDAO;
import com.smart.dao.UserDao;
import com.smart.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserDao userDao;
    private LoginLogDAO loginLogDAO;

    @Autowired
    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }

    @Autowired
    public void setLoginLogDAO(LoginLogDAO loginLogDAO){
        this.loginLogDAO = loginLogDAO;
    }


}
