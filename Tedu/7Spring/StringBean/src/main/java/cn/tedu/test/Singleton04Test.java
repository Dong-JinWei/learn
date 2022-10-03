package cn.tedu.test;

import cn.tedu.bean.Singleton04;

public class Singleton04Test {

    public static void main(String[] args) throws ClassNotFoundException {
        Singleton04 s1 = Singleton04.getSingleton04();
        Singleton04 s4 = Singleton04.getSingleton04();

        System.out.println(s1 == s4);

        Class.forName("cn.tedu.bean.Singleton04");

    }

}
