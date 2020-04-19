package com.mxixm.spring.boot.controller;

import com.mxixm.spring.boot.domian.Fruit;
import com.mxixm.spring.boot.service.FruitService;
import com.mxixm.spring.boot.service.FruitServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class FruitController {
    private FruitService fruitService = new FruitServiceImpl();
    @RequestMapping("/queryFruitList")
    public ModelAndView queryFruitList() throws Exception{
        List<Fruit> fruitList = fruitService.queryFruitList();
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(fruitList.get(0).getLocation());
        modelAndView.addObject("fruitsList",fruitList);

        return modelAndView;
    }

}


