package com.haibo.future.web.models.impl;

import com.haibo.future.web.aop.Cache;
import com.haibo.future.web.models.Animal;

public class Cat implements Animal{
    @Cache(1)
    @Override
    public String sayName(String name, Integer num) {
        return "this cat Name is "+name+","+num;
    }
}
