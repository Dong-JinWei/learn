package day0408;

public class ATest {
    public static void main(String[] args) {
        //如何创建内部类对象：外部类.内部类 对象名 = new 外部类().new 内部类();
        A.B b = new A().new B();
        b.show();
        b.show1();


    }
}
