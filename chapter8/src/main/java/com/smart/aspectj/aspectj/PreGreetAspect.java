package com.smart.aspectj.aspectj;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class PreGreetAspect {
    @Before("execution(* greetTo(..))")
    public void beforeGreeting(){
        System.out.println("hello");
    }
}
