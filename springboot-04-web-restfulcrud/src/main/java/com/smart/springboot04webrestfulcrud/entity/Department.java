package com.smart.springboot04webrestfulcrud.entity;

public class Department {
    private Integer id;
    private String DepartmentName;

    public Department(Integer id, String departmentName) {
        this.id = id;
        DepartmentName = departmentName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return DepartmentName;
    }

    public void setDepartmentName(String departmentName) {
        DepartmentName = departmentName;
    }
}
