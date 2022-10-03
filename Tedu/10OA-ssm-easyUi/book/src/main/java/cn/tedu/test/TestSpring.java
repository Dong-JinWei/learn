package cn.tedu.test;

import cn.tedu.pojo.Book;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        Book book = classPathXmlApplicationContext.getBean("book", Book.class);
        System.out.println(book);
    }

}
