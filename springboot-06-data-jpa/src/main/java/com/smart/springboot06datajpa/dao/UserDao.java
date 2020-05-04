package com.smart.springboot06datajpa.dao;

import com.smart.springboot06datajpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserDao extends JpaRepository<User,Integer> {

}
