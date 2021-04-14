package com.yc.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class HelloWorld {
    @PostConstruct
    public void setup() {
        System.out.println("postconstrcut");
    }

    @PreDestroy
    public void destory() {
        System.out.println("predestroy");
    }

    public HelloWorld() {
        System.out.println("构造方法");
    }

    public void show() {
        System.out.println("show");
    }
}
