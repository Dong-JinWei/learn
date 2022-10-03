package cn.tedu;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class OtherAfter implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("after... do something....");
    }
}
