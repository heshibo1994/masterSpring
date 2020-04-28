package com.fruitsalesplatform.service;

import com.fruitsalesplatform.entity.Commodities;
import com.fruitsalesplatform.entity.Retailer;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface CommoditiesService {
    // 只查询一个数据，常用于修改
    public Commodities get(Serializable id);
    // 根据条件查询多个结果,map里面是条件
    public List<Commodities> find(Map map);
    // 插入，以entity为入参
    public void insert(Commodities commodities);
    // 修改，以entity为入参
    public void update(Commodities commodities);
    // 以id进行删除
    public void deleteById(Serializable id);
    // 批量删除
    public void delete(Serializable[] ids);
    // 统计结果集数量
    public int count(Map map);
}
