package com.smart.service;

import com.smart.dao.LoginLogDao;
import com.smart.dao.UserDao;

import com.smart.domain.LoginLog;
import com.smart.domain.User;
import com.smart.exception.UserExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class UserService {

    private UserDao userDao;

    private LoginLogDao loginLogDao;
    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    @Autowired
    public void setLoginLogDao(LoginLogDao loginLogDao) {
        this.loginLogDao = loginLogDao;
    }

    // 注册
    public void register(User user) throws UserExistException {
        User u = this.getUserByUserName(user.getUserName());
        if (u !=null){
            throw  new UserExistException("用户已存在");
        }else{
            user.setCredit(100);
            user.setUserType(1);
            userDao.save(user);
        }
    }

    // 更新用户
    public void update(User user){
        userDao.update(user);
    }

    // UserId加载User对象
    public User getUserByUserId(int userId){
        return userDao.get(userId);
    }
    // 锁定用户
    public void lockUser(String userName){
        User user = userDao.getUserByUserName(userName);
        user.setLocked(User.USE_LOCK);
    }
    // 解锁用户
    public void unLockUser(String userName){
        User user = userDao.getUserByUserName(userName);
        user.setLocked(User.USE_UNLOCK);
    }

    public User getUserByUserName(String userName) {
        return userDao.getUserByUserName(userName);
    }
    public List<User> queryUserByUserName(String userName){
        return userDao.queryUserByUserName(userName);
    }

    public List<User> getAllUsers(){
        return userDao.loadall();
    }

    // 登录成功
    public void loginSuccess(User user){
        user.setCredit(5+user.getCredit());
        LoginLog loginLog = new LoginLog();
        loginLog.setLoginDate(new Date());
        loginLog.setIp(user.getLastIp());
        loginLog.setUser(user);
        userDao.update(user);
        loginLogDao.save(loginLog);
    }
}
