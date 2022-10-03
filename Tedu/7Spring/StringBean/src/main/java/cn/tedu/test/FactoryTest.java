package cn.tedu.test;

import cn.tedu.bean.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactoryTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = context.getBean("userFac", User.class);
        System.out.println(user);

        User usrFac2 = context.getBean("userFac2", User.class);
        System.out.println(usrFac2);

        User userFac3 = context.getBean("userFac3", User.class);
        System.out.println(userFac3);
    }
}
