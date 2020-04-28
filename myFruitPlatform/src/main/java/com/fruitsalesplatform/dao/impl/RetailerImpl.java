package com.fruitsalesplatform.dao.impl;

import com.fruitsalesplatform.dao.RetailerDao;
import com.fruitsalesplatform.entity.Retailer;
import org.springframework.stereotype.Repository;

import java.util.Map;
@Repository //为了包扫描的时候这个Dao被扫描到
public class RetailerImpl extends BaseDaoImpl<Retailer> implements RetailerDao {
    public RetailerImpl(){
        super.setNs("com.fruitsalesplatform.mapper.RetailerMapper");
    }

    @Override
    public int count(Map map) {
        return this.getSqlSession().selectOne(this.getNs()+".count",map);
    }
}
