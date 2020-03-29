package com.smart.aspectj.anno;

import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class ToolTest {
    @Test
    public void tool(){
        Class clazz = ForumService.class;
        Method[] methods = clazz.getDeclaredMethods();
        System.out.println(methods.length);
        for (Method m :methods){
            NeedTest nt = m.getAnnotation(NeedTest.class);
            if (nt.value()){
                System.out.println("方法："+m.getName()+"需要被测试");
            }else{
                System.out.println("方法："+m.getName()+"不需要被测试");
            }
        }
    }
}
