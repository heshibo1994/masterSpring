package com.fruitsalesplatform.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

// 泛型代表不同的实体bean
public interface BaseDao<T> {
    // 只查询一个数据，常用于修改
    public T get(Serializable id);
    // 根据条件查询多个结果,map里面是条件
    public List<T> find(Map map);
    // 插入，以entity为入参
    public void insert(T entity);
    // 修改，以entity为入参
    public void update(T entity);
    // 以id进行删除
    public void deleteById(Serializable id);
    // 批量删除
    public void delete(Serializable[] ids);
}
