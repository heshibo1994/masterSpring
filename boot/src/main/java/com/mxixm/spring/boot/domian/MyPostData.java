package com.mxixm.spring.boot.domian;

import javax.validation.constraints.Min;

public class MyPostData {
    private String name;
    @Min(0)
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "MyPostData{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
