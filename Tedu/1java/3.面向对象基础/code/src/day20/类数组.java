package day20;

/**
 * @author 26465
 * @create 2022-01-13 11:13
 */
public class 类数组 {
    public static void main(String[] args) {
        B[] b = new B[4];
        b[0] = new B();
        for (int i = 1; i < b.length; i++) {
            b[i] = new B(i);
        }
        for (int i = 0; i < b.length; i++) {
            b[i].f();
        }
    }
}

class B {
    int n;

    B() {
        System.out.println("B()");
    }

    B(int n) {
        this.n = n;
        System.out.println("B(int n)");
    }

    void f() {
        System.out.println("***" + this.n);
    }
}
