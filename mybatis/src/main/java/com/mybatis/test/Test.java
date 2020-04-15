package com.mybatis.test;

import com.mybatis.datasource.DataConnection;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        DataConnection dataConnection = new DataConnection();
        Object o = dataConnection.getSqlSession();
    }
}
