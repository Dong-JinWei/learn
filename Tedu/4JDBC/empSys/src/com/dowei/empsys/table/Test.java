package com.dowei.empsys.table;


public class Test {
    public static void main(String[] args) {
        A a = new Test().new A();
    }

    public void show(){
        System.out.println("你好");
    }

    public class A{

//        public void show(){
//            System.out.println("JAVA");
//        }

        public A(){
            show();
        }
    }
}
