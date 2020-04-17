package com.mybatis.mapper;

public interface CustomerMapper {
    public User findUserById(int id) throws Exception;
    public void insertUser(User user) throws Exception;
    public void deleteUserById(int id) throws Exception;
    public void updateUserSex(User user) throws Exception;
}
