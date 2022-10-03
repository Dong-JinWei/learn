package day26.test2;

import day26.test1.A;

/**
 * @author 26465
 * @create 2022-01-20 17:17
 */
public class B extends A {

    {
        System.out.println();
        System.out.println("B 代码块");
    }

    void f(int f) {
        System.out.println("mm");
    }

    public B() {
        super();
        System.out.println("B()");
    }
}
