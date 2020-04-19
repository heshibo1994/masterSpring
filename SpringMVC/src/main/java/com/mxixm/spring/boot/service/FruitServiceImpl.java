package com.mxixm.spring.boot.service;

import com.mxixm.spring.boot.domian.Fruit;

import java.util.ArrayList;
import java.util.List;

public class FruitServiceImpl implements FruitService {
    @Override
    public List<Fruit> queryFruitList() {
        List <Fruit>fruitList  = new ArrayList<Fruit>();
        fruitList.add(new Fruit("红富士",3.0,"北京"));
        fruitList.add(new Fruit("小香蕉",2.5,"武汉"));
        fruitList.add(new Fruit("哈密瓜",4.8,"上海"));
        return fruitList;
    }
}
