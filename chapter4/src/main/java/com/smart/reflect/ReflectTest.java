package com.smart.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectTest {
    //通过类加载器获得Car对象
    public static Car initByDefaultConst() throws Throwable{
        //通过类加载器获得Car对象
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class clazz = loader.loadClass("com.smart.reflect.Car");
        //获取类的默认构造器对象并通过实例化Car
        Constructor cons = clazz.getDeclaredConstructor((Class[] )null);
        Car car = (Car)cons.newInstance();
        //通过反射方法获取属性
        Method setBrand = clazz.getMethod("setBrand",String.class);
        Method setColor = clazz.getMethod("setColor",String.class);
        Method setMaxSpeed = clazz.getMethod("setMaxSpeed",int.class);
        setBrand.invoke(car,"法拉利");
        setColor.invoke(car,"red");
        setMaxSpeed.invoke(car,299);
        return car;
    }

    public static void main(String[] args) throws Throwable {
        Car car = initByDefaultConst();
        car.introduce();
    }


}
