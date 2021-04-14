package com.yc;

import org.springframework.stereotype.Component;

@Component
public class HelloWorld {
    public HelloWorld(){
        System.out.println("调用成功");
    }

    public void execute(){
        System.out.println("执行一个方法!");
    }
}
