package com.smart.fb;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("com.smart.fb/bean.xml");
        CarFactoryBean cfb= (CarFactoryBean)context.getBean("car");
        System.out.println(cfb.getCarInfo());
    }
}
