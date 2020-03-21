package com.smart.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogonServer {
//    @Autowired(required = false)
//    private LogDao logDao;
//    @Autowired
//    private UserDao userDao;
    private LogDao logDao;
    private UserDao userDao;
    @Autowired
    public void setLogDao(LogDao logDao) {
        this.logDao = logDao;
    }
    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
