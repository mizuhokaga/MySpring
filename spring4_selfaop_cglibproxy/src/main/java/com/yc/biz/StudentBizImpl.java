package com.yc.biz;

public class StudentBizImpl {
    public int add(String name) {
        System.out.println("调用了studentbizimpl 的add:"+name);
        return 1;
    }
    public String find(String name) {
        System.out.println("调用了studentbizimpl 的find方法找到了："+name);
        return name;
    }
}
