package day28;

/**
 * @author 26465
 * @create 2022-01-24 10:55
 */
public class test {
    public static void main(String[] args) {
        B b = new B();
        A a;
        a = new B();
        a.f(2,1,3);
    }
}

class A{
    public void f(int... arr){
        System.out.println("int .. a");
    }

}

class B extends A{
    public void f(int[] arr){
        System.out.println("arr");
    }
}
