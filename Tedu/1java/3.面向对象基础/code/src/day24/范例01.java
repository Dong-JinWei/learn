package day24;

/**
 * @author 26465
 * @create 2022-01-19 10:12
 */
class C{
    int a;
    C(){
        a = 1;
        System.out.println("C()");
    }
    C(int a){
        this.a = a;
        System.out.println("C(int a)");
    }
}
class D extends C{
    int b;
    D(int a, int b){
        super(a);
        this.b = b;
        super.a = 3;
        System.out.println("D(int a, int b)");
    }
}
public class 范例01 {
    public static void main(String[] args) {
        D od = new D(1, 2);
        System.out.println(od.a+" "+od.b);
    }
}
/*
C(int a)
D(int a, int b)
3 2
 */
