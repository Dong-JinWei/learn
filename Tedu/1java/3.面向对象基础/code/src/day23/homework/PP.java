package day23.homework;

public class PP {
    public static void main(String[] args) {
        B ob = new B();
        ob.f();
        ob.f(123);
        ob.h();
        System.out.println(ob.a);
        System.out.println(ob.b);
        System.out.println(A.b);
        System.out.println(B.b);
        System.out.println("++++++++++++++++++++++++++");
        ob.m();
    }
}

/*
B f()
B f(int a)
A h()
1001
1002
2
1002
 */
class A {
    int a = 1;
    static int b = 2;
    int c = 3;
    static int d = 4;

    void f() {
        System.out.println("A f()");
    }

    static void g() {
        System.out.println("A static g()");
    }

    void h() {
        System.out.println("A h()");
    }
}

class B extends A {
    int a = 1001;
    static int b = 1002;

    void f() {
        System.out.println("B f()");
    }

    void f(int a) {
        System.out.println("B f(int a)");
    }

    static void g() {
        System.out.println("B static g()");
    }

    void m() {
        int a = 77, b = 99;
        //调用B中的f()方法
        f();
        //调用A中的f()方法
        super.f();
        //调用B中的f(int a)方法
        f(5);
        //调用B中的g()方法
        g();
        //调用A中的g()方法
        super.g();
        //输出A中的a b的值
        System.out.println(super.a + " " +super.b);
        //输出B中的a b的值
        System.out.println(this.a + " " + this.b);
        //输出 c d 成员的值
        System.out.println(c + " " + d);
        //System.out.println(super.c + " " + super.d);
        //输出局部变量的a b的值
        System.out.println(a + " " + d);
    }
}

