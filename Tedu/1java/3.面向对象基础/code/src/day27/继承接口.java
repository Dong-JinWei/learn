package day27;

/**
 * @author 26465
 * @create 2022-01-21 11:06
 */
interface A {
    int a = 1;

    void fa();
}

interface B {
    int b = 2;

    void fb();
}

interface C extends A, B {
//    int c=3;
//    void fc();
}

class D implements C {
    @Override
    public void fa() {
    }

    @Override
    public void fb() {
    }
}

class E implements A, B {
    @Override
    public void fa() {
    }

    @Override
    public void fb() {
    }
}

public class 继承接口 {
    static void f1(A oa) {
    }

    static void f2(B ob) {
    }

    static void f3(C oc) {
    }

    public static void main(String[] args) {
        D d = new D();
        E e = new E();

        f1(d);
        f2(d);
        f3(d);
        f1(e);
        f2(e);
//        f3(e);

    }
}
