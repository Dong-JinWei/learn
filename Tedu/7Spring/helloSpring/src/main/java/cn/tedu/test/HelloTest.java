package cn.tedu.test;

import cn.tedu.bean.Student;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //Student stuBean = context.getBean("stuBean", Student.class);
        Student stuBean = context.getBean("stu", Student.class);
        System.out.println(stuBean);
        context.close();
    }
}
