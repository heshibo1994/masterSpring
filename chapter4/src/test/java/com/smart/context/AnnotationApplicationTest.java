package com.smart.context;

import com.smart.reflect.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;
import org.testng.annotations.Test;

public class AnnotationApplicationTest {
    @Test
    public void getBean(){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Beans.class);
        Car car1 = ctx.getBean("car1", Car.class);
        car1.introduce();

        ApplicationContext ctx2 = new GenericGroovyApplicationContext("groovy-beans.groovy");
        Car car2 = (Car)ctx2.getBean("car2");
        car2.introduce();
    }

    public static void main(String[] args) {
        AnnotationApplicationTest annotationApplicationTest = new AnnotationApplicationTest();
        annotationApplicationTest.getBean();
    }
}
