package LogAspect;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogAspectCglib implements MethodInterceptor {
    private Object target;

    public LogAspectCglib(Object target) {
        this.target = target;
    }

    public Object creataProxy(){
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override//拦截
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
       if(method.getName().startsWith("add"))
       {
           log();
       }

       Object retVal=method.invoke(this.target,args);
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
