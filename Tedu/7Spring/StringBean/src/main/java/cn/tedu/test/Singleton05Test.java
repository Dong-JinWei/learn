package cn.tedu.test;

import cn.tedu.bean.Singleton05;

public class Singleton05Test {

    public static void main(String[] args) throws ClassNotFoundException {
        //Singleton05 instance = Singleton05.getInstance();
        //Singleton05 instance1 = Singleton05.getInstance();
        //
        //System.out.println(instance == instance1);

        Class.forName("cn.tedu.bean.Singleton05");
    }

}
