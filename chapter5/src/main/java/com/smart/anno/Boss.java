package com.smart.anno;

import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.*;
public class Boss {
    private Car car;
    public Boss(){
        System.out.println("construct");
    }
    @Autowired
    private void setCar(Car car){
        System.out.println("execute in setCar");
        this.car = car;
    }
    private void init1(){
        System.out.println("exe in init1");
    }

    private void init2(){
        System.out.println("exe in init2");
    }

    private void destory1(){
        System.out.println("exe in destory1");
    }

    private void destory2(){
        System.out.println("exe in destory2");
    }

}
