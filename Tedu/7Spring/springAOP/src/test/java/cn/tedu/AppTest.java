package cn.tedu;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Method;

public class AppTest {

    @Test
    public void proxyTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Play proxy = context.getBean("proxy", Play.class);
        proxy.showTime();
    }
}
