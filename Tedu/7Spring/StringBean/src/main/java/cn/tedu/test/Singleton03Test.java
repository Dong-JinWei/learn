package cn.tedu.test;

import cn.tedu.bean.Singleton03;

public class Singleton03Test {

    public static void main(String[] args) throws ClassNotFoundException {
        Singleton03 s1 = Singleton03.getSingleton03();
        Singleton03 s3 = Singleton03.getSingleton03();

        System.out.println(s1 == s3);

        Class.forName("cn.tedu.bean.Singleton03");

    }

}
