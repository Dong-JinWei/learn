package cn.tedu;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class OtherBefore implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("before.... do something...");
    }
}
