package cn.tedu;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class OtherAround implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("around....before...do something...");
        //调用被代理对象(目标对象)中的业务处理方法。
        Object proceed = methodInvocation.proceed();
        System.out.println("around... after... do something...");
        return proceed;
    }
}
