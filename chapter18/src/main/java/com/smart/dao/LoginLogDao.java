package com.smart.dao;

import com.smart.domain.LoginLog;
import org.springframework.stereotype.Repository;

@Repository
public class LoginLogDao extends BaseDao<LoginLog> {
    public void save(LoginLog loginLog) {
        this.getHibernateTemplate().save(loginLog);
    }
}
