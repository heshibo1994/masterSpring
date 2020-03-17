package com.smart.tagdepend;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("com.smart.tagdepend/bean.xml");
        Car car = (Car) context.getBean("car1");
        System.out.println(car);
    }
}
