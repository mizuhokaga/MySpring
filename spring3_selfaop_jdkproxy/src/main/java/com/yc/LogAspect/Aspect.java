package com.yc.LogAspect;


import com.yc.biz.StudentBiz;
import org.springframework.util.StringUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Aspect implements InvocationHandler {
    private Object object; //目标类

    //中介类持有一个委托类的实例
    public Aspect(Object object) {
        this.object = object;
    }

    public Object createProxy() {//最后一个参数是 handler，aspect类自己继承了这个接口，直接填入自身
        return Proxy.newProxyInstance(this.object.getClass().getClassLoader(), this.object.getClass().getInterfaces(), this);
    }


    @Override// jvm callback method, 当jvm调用代理对象的被调用方法，jvm自动调用该方法
    //构成静态代理
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("中介类对象" + proxy.getClass());
        System.out.println("委托类方法" + method);
        System.out.println("method 参数:" + args);
        System.out.println("++++++++++++++++");
        if (method.getName().startsWith("add")) {
            log();
        }
        Object retVal = method.invoke(this.object, args);
        return retVal;
    }

    private void log() {
        System.out.println("前置增强+++++++++++");
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = sdf.format(date);
        System.out.println("当前时间：" + s);
        System.out.println("前置增强结束+++++++++++");
    }
}
