package day26.test1;

public class A {
    int a = 1;
    int b = 2;

    static {
        System.out.println("A static 代码块");
    }

    public A() {

    }

    void f() {
        System.out.println("A ");
    }
}
