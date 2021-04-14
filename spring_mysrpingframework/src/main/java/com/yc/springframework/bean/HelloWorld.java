package com.yc.springframework.bean;

import com.yc.springframework.stereotype.MyComponent;
import com.yc.springframework.stereotype.MyPostConstruct;
import com.yc.springframework.stereotype.MyPreDestory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@MyComponent
public class HelloWorld {
    @MyPostConstruct
    public void setup() {
        System.out.println("myPostConstruct");
    }

    @MyPreDestory
    public  void  destory(){
        System.out.println("MyPreDesotry");
    }

    public HelloWorld() {
        System.out.println("HelloWorld");
    }

    public void execute(){
        System.out.println("execute");
    }

}
