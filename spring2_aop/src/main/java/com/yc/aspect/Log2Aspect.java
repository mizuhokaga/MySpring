package com.yc.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect//申明切面类
@Component//aop基于ioc
@Order(value = 100)
public class Log2Aspect {

    @Around("execution(* com.yc.biz.StudentBizImpl.find*(..))")
    public Object compute(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕增强+++++++++++Log2Aspect");
        long start=System.currentTimeMillis();
        Object retVal=pjp.proceed();
        long end =System.currentTimeMillis();
        System.out.println("花费时间："+(end-start));
        System.out.println("环绕增强结束+++++++++++Log2Aspect");
        return retVal;
    }

}
//1.