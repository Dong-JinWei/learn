package day21.finalTest;

/**
 * @author 26465
 * @create 2022-01-14 19:40
 */
public class FinalTest {
    public static void main(String[] args) {
        int r = 5;
        System.out.println(Test.PI * r);
        System.out.println(Test.PI * 2 * r);


    }
}
class Test{
    static final float PI = 3.1415926f;
}
