package day21;

/**
 * @author 26465
 * @create 2022-01-14 9:19
 */
public class StaticTest {
    public static void main(String[] args) {
        StaticVar staticVar1 = new StaticVar();
        StaticVar staticVar2 = new StaticVar();
        StaticVar staticVar3 = new StaticVar();
        staticVar1.add();
        staticVar1.add();
        staticVar2.add();
        staticVar2.add();

        System.out.println(StaticVar.sta(5));

        StaticVar.StaInterClass staInterClass = new StaticVar.StaInterClass();
        staInterClass.show();
    }


}

class StaticVar {
    static int count1 = 0;
    static int count2 = 0;

    static {
        System.out.println("执行了一次静态代码块");
    }

    {
        count2++;
        System.out.println("非静态代码块：" + count2);
    }

    void add() {
        count1++;
        System.out.println("非静态方法add() count1: " + count1);
    }

    static int sta(int x) {
        System.out.print("静态方法: ");
        return x * x * x;
    }

    static class StaInterClass{
        static {
            System.out.println("静态内部类的静态代码块");
        }
        void show(){
            System.out.println("静态内部类方法");
        }
    }
}

