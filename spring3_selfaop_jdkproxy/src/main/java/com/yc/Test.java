package com.yc;

import com.yc.LogAspect.Aspect;
import com.yc.biz.StudentBiz;
import com.yc.biz.StudentBizImpl;

public class Test {

    public static void main(String[] args) {
        StudentBiz student =new StudentBizImpl();

        Aspect aspect=new Aspect(student);//aspect 是代理类 ，student 是委托类
        Object obj=aspect.createProxy();
        if(obj instanceof  StudentBiz){
            StudentBiz sb=(StudentBiz) obj;
            sb.find("mizuho");//jvm 会感知 sb是一个proxy ，所以最终 jvm 会调用proxy里的 invoke

            sb.add("mizuhokaga");
            sb.update("kaga");
        }
    }
}
