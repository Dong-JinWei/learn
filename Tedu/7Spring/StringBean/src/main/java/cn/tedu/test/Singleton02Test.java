package cn.tedu.test;

import cn.tedu.bean.Singleton02;

public class Singleton02Test {
    public static void main(String[] args) throws ClassNotFoundException {
        //Singleton02 s1 = Singleton02.getSingleton02();
        //Singleton02 s2 = Singleton02.getSingleton02();
        //
        //System.out.println(s1 == s2);

        Class.forName("cn.tedu.bean.Singleton02");

    }
}
