package day20;

/**
 * @author 26465
 * @create 2022-01-13 11:32
 */
public class 内部类 {
    public static void main(String[] args) {
        InterTest.Test test;
        test = new InterTest.Test();
        test.f();

    }
}

class InterTest{
    private int n;
    static class Test{
        Test(){
            System.out.println("内部类Test()被调用");
        }
        void f(){
            int n = 1;
            System.out.println("Test.f(): " + n);
        }
    }
}
