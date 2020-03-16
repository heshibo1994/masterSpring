package com.smart.beanfactory;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

public class BeanFactoryTest {
    public void getBean() throws Throwable{
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource res = resolver.getResource("classpath:com/smart/beanfactory/beans.xml");

        System.out.println(res.getURI());
    }

    public static void main(String[] args) throws Throwable {
        BeanFactoryTest beanFactoryTest = new BeanFactoryTest();
        beanFactoryTest.getBean();
    }
}
