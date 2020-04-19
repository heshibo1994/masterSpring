package com.sm.test;

import com.sm.dao.UserDao;
import com.sm.po.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class UserServiceTest {
    private ApplicationContext applicationContext;
    @Before
    public void setup() throws Exception{
        applicationContext = new ClassPathXmlApplicationContext(
                "classpath:config/spring/applicationContext.xml");
    }

    @Test
    public void testFindUserById() throws Exception {
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        User user = userDao.findUserById(1);
        System.out.println(user);

    }
}
