package day21.memory;


public class MemoryLeaksTest {
    public static void main(String[] args) {
        Test2 test2 = new Test2();
        test2.f();
    }
}

class Test1 {

}

class Test2 {
    Test1 test1;

    void f() {
        test1 = new Test1();
    }
}
