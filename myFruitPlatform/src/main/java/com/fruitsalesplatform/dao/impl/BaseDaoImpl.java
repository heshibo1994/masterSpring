package com.fruitsalesplatform.dao.impl;

import com.fruitsalesplatform.dao.BaseDao;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

// 1.获取回话工厂SqlSessionFactory
// 2.获取操作数据库的会话对象SqlSession
// 3.实现接口方法

public abstract  class BaseDaoImpl<T> extends SqlSessionDaoSupport implements BaseDao<T> {
    // 1
    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    // 统一命名空间
    private String ns;
    public void setNs(String ns){
        this.ns = ns;
    }

    public String getNs() {
        return ns;
    }

    // 3
    @Override
    public T get(Serializable id) {
        return this.getSqlSession().selectOne(ns+".get",id);
    }

    @Override
    public List<T> find(Map map) {
        return this.getSqlSession().selectList(ns+".find",map);
    }

    @Override
    public void insert(T entity) {
        this.getSqlSession().insert(ns+".insert",entity);
    }

    @Override
    public void update(T entity) {
        this.getSqlSession().update(ns+".update",entity);
    }

    @Override
    public void deleteById(Serializable id) {
        this.getSqlSession().delete(ns+".delete",id);
    }

    @Override
    public void delete(Serializable[] ids) {
        this.getSqlSession().delete(ns+".delete",ids);
    }
}
