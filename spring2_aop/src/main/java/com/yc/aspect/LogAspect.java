package com.yc.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.sound.midi.Soundbank;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

@Aspect//申明切面类
@Component//aop基于ioc
@Order(value =  1)
public class LogAspect {

    @Pointcut("execution(* com.yc.biz.StudentBizImpl.add*(..))")//pointcut expression
    private void add() {//point signature
    }
    @Pointcut("execution(* com.yc.biz.StudentBizImpl.update*(..))")
    private void update() {
    }
    @Pointcut("add()|| update()")
    private  void addAndUpdate(){

    }
//   execution(modifiers-pattern? ret-type-pattern declaring-type-pattern?name-pattern(param-pattern)
//                throws-pattern?)

//    @Before("com.yc.aspect.LogAspect.addAndUpdate()")
//    private  void log(){
//        System.out.println("前置增强+++++++++++");
//        Date date=new Date();
//        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String s=sdf.format(date);
//        System.out.println("时间："+s);
//        System.out.println("前置增强结束+++++++++++");
//    }

    @Around("execution(* com.yc.biz.StudentBizImpl.find*(..))")
    public Object compute(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕增强+++++++++++LogAspect");
        long start=System.currentTimeMillis();
        Object retVal=pjp.proceed();
        long end =System.currentTimeMillis();
        System.out.println("花费时间："+(end-start));
        System.out.println("环绕增强结束+++++++++++LogAspect");
        return retVal;
    }

}
//1.