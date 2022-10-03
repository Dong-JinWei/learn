package cn.tedu.test;

import cn.tedu.bean.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

        User user01 = context.getBean("user01", User.class);
        System.out.println(user01);


        ClassPathXmlApplicationContext context2 = new ClassPathXmlApplicationContext("p.xml");

        User user02 = context2.getBean("user02", User.class);
        System.out.println(user02 );

        user02 = context2.getBean("user03", User.class);
        System.out.println(user02);

        ClassPathXmlApplicationContext context3 = new ClassPathXmlApplicationContext("propertiesTest.xml");

        User user04 = context3.getBean("user04", User.class);
        System.out.println(user04);

    }

}
