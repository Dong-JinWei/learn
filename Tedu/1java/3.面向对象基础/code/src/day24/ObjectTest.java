package day24;

/**
 * @author 26465
 * @create 2022-01-19 16:30
 */
public class ObjectTest {
    public static void main(String[] args) {
        A oa;
        B ob;
        oa = new B();
        ob = (B)oa;

        oa.f();
        oa.g();
        ob.f();
        ob.g();
        System.out.println(oa.a);
        System.out.println(oa.b);
        System.out.println(ob.a);
        System.out.println(ob.b);
    }
}
/*
B f()
A static g()
B f()
B static g()
1
2
3
4
 */
class A{
    int a=1;
    static int b=2;
    void f(){
        System.out.println("A f()");
    }
    static void g(){
        System.out.println("A static g()");
    }
}
class B extends A{
    int a=3;
    static int b=4;
    void f(){
        System.out.println("B f()");
    }
    static void g(){
        System.out.println("B static g()");
    }
}

