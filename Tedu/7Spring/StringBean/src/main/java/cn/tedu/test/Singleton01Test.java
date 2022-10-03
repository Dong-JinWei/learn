package cn.tedu.test;

import cn.tedu.bean.Singleton01;

public class Singleton01Test {
    public static void main(String[] args) throws ClassNotFoundException {

        Singleton01 singleton01 = Singleton01.getSingleton01();
        Singleton01 singleton02 = Singleton01.getSingleton01();

        System.out.println(singleton01 == singleton02);
        Class.forName("cn.tedu.bean.Singleton01");
    }
}
