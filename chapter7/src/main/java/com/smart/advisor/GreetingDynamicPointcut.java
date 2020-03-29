package com.smart.advisor;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class GreetingDynamicPointcut extends DynamicMethodMatcherPointcut {
    private static List<String> specialList = new ArrayList<String>();
    static{
        specialList.add("Join");
        specialList.add("tom");
    }

    public ClassFilter getClassFilter(Method method, Class<?> aClass, Object[] objects) {
        return new ClassFilter() {
            @Override
            public boolean matches(Class<?> clazz) {
                System.out.println("对累的静态检查");
                return Waiter.class.isAssignableFrom(clazz);
            }
        };
    }


    @Override
    public boolean matches(Method method, Class<?> aClass) {
        System.out.println("对方法的静态检查");
        return "greetTo".equals(method.getName());
    }

    @Override
    public boolean matches(Method method, Class<?> aClass, Object[] objects) {
        System.out.println("对方法的动态检查");
        return specialList.contains((String)objects[0]);
    }

}
