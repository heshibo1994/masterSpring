package com.mxixm.spring.boot.domian;

import java.util.List;
import java.util.Map;

public class PersonData {
    private String name;
    private Nested nested;
    private String[] hobbies;
    private List<String> things;
    private Map<String,String> properties;
    private Map<String,Nested> nestedProperties;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Nested getNested() {
        return nested;
    }

    public void setNested(Nested nested) {
        this.nested = nested;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    public List<String> getThings() {
        return things;
    }

    public void setThings(List<String> things) {
        this.things = things;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }

    public Map<String, Nested> getNestedProperties() {
        return nestedProperties;
    }

    public void setNestedProperties(Map<String, Nested> nestedProperties) {
        this.nestedProperties = nestedProperties;
    }

    public static class Nested{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
