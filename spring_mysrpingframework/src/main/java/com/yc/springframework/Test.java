package com.yc.springframework;

import com.yc.springframework.bean.HelloWorld;
import com.yc.springframework.biz.StudentBizImpl;
import com.yc.springframework.context.MyAnnotationConfigApplicationContext;
import com.yc.springframework.context.MyApplicationContext;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Test {

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException {
        MyApplicationContext ac=new MyAnnotationConfigApplicationContext(MyAppConfig.class);
        HelloWorld hw=(HelloWorld) ac.getBean("helloWorld");
        System.out.println(hw);
        hw.execute();
        StudentBizImpl studentBiz = (StudentBizImpl) ac.getBean("studentBizImpl");
        studentBiz.add("abc");
    }
}
