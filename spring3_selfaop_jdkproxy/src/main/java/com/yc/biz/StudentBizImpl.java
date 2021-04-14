package com.yc.biz;

//jdk 动态代理基于接口 所以一定要基于接口
public class StudentBizImpl implements StudentBiz {
    @Override
    public int add(String name) {
        System.out.println("调用了studentbizimpl 的add:"+name);
        return 1;
    }

    @Override
    public void update(String name) {
        System.out.println("调用了studentbizimpl 的update："+name);
    }

    @Override
    public String find(String name) {
        System.out.println("调用了studentbizimpl 的find方法找到了："+name);
        return name;
    }
}
