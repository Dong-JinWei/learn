package day24.homework;

/**
 * @author 26465
 * @create 2022-01-19 17:08
 */
public class FiledMethodTest {
    public static void main(String[] args) {
        Sub s = new Sub();
        System.out.println(s.count);
        s.display();
        Base b = s;
        System.out.println(b == s);
        System.out.println(b.count);
        b.display();
    }
}
/*
20
20
true
10
20
 */
class Base{
    int count = 10;
    public void display(){
        System.out.println(this.count);
    }
}

class Sub extends Base{
    int count = 20;
    public void display(){
        System.out.println(this.count);
    }
}