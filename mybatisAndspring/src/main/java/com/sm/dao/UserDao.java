package com.sm.dao;

import com.sm.po.User;

public interface UserDao {
    public User findUserById(int id) throws Exception;
}
