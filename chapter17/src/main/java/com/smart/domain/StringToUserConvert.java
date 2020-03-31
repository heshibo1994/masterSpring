package com.smart.domain;


import org.springframework.core.convert.converter.Converter;

public class StringToUserConvert implements Converter<String,User> {
    @Override
    public User convert(String s) {
        User user = new User();
        if(s!=null){
            String[] item = s.split(":");
            user.setUserName(item[0]);
            user.setPassword(item[1]);
            user.setRealName(item[2]);
        }
        return user;
    }
}
