package jdbc0327;

public class Book {
    public Book(){
        System.out.println("构造方法");
    }
    {
        System.out.println("代码块");
    }
    static {
        System.out.println("静态代码块");
    }
}
