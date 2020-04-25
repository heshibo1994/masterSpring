package com.fruitsalesplatform.dao.impl;

import com.fruitsalesplatform.dao.UserDao;
import com.fruitsalesplatform.entity.User;
import org.springframework.stereotype.Repository;

@Repository //为了包扫描的时候这个Dao被扫描到
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
    public UserDaoImpl() {
        super.setNs("com.fruitsalesplatform.mapper.UserMapper");
    }
}
