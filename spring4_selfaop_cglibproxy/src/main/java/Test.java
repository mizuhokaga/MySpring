import LogAspect.LogAspectCglib;

import com.yc.biz.StudentBizImpl;

public class Test {

    public static void main(String[] args) {
        int x=2;//符号位 1
        int y=-1;//符号位 0
        x=-~x;
        int s=x^y;
        boolean f=(x^y) >0;
        System.out.println(x);
//        StudentBizImpl student =new StudentBizImpl();
//
//        LogAspectCglib aspect=new LogAspectCglib(student);//aspect 是代理类 ，student 是委托类
//        Object obj=aspect.creataProxy();
//        if(obj instanceof  StudentBizImpl){
//            StudentBizImpl sb=(StudentBizImpl) obj;
//            sb.find("mizuho");//jvm 会感知 sb是一个proxy ，所以最终 jvm 会调用proxy里的 invoke
//
//            sb.add("mizuhokaga");
//
//        }
    }
}
