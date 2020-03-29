package com.smart.advice;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class GreetingInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object[] args = invocation.getArguments();
        String name = (String)args[0];
        System.out.println("hello:"+name);

        Object obj = invocation.proceed();

        System.out.println("bye,bye:"+name);
        return obj;
    }
}
