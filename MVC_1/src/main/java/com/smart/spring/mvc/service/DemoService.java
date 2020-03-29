package com.smart.spring.mvc.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DemoService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public String getName(int id){
        String sql = "select name from user where id=?";
        return jdbcTemplate.queryForObject(sql,String.class,id);
    }
}



