package com.mybatis.test;

import com.mybatis.datasource.DataConnection;
import com.mybatis.mapper.CustomerMapper;
import com.mybatis.mapper.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class DynamicProxyTest {
    public DataConnection dataConnection = new DataConnection();

    @Test
    public void testFindUserById() throws Exception{
        SqlSession sqlSession = dataConnection.getSqlSession();
        CustomerMapper customMapper = sqlSession.getMapper(CustomerMapper.class);
        User user = customMapper.findUserById(1);
        System.out.println(user.getUsername());
    }
}
