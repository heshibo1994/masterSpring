package com.fruitsalesplatform.controller;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public abstract class BaseController {
    @InitBinder
    public void initBinder(WebDataBinder binder){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(true);
        binder.registerCustomEditor(Date.class,new CustomDateEditor(dateFormat,true));

    }
}
