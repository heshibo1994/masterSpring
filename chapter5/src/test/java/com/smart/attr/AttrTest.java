package com.smart.attr;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AttrTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("com.smart.attr/beanattr.xml");
        Boss boss = (Boss)context.getBean("boss1");
        System.out.println(boss.getFavorites());
        System.out.println(boss.getJobs());
        System.out.println(boss.getMails());
        System.out.println(boss.getJobTimes());

        Boss  childBoss= (Boss)context.getBean("childBoss");
        System.out.println(childBoss.getFavorites());
    }
}
