package com.smart.ditype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DiTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("com.smart.ditype/bean_p.xml");
        Boss boss = (Boss)context.getBean("boss");
        System.out.println(boss.getCar().getBrand());
    }
}
