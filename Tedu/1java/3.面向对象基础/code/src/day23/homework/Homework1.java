package day23.homework;

public class Homework1{
    public static void main(String[] args) {
        Path path = new Path();
        Raul raul = new Raul();

        System.out.println("路面所花费的钱是："+path.getMoney());
        System.out.println("栏杆所花费的钱是："+raul.getMoney());

    }

}

class Pond{
    public static final double PI = 3.14;
    double radiusPath = 20; //路面半径，大圆半径
    double radiusRaul = 10; //栏杆半径， 小圆半径
}

class Path extends Pond{
    double money = 10; // 每平方米10块钱

    public double getMoney(){
        //同心圆的面积（R^2 - r^2) * PI
        return (radiusPath * radiusPath - radiusRaul * radiusRaul) * PI * money;
    }

}

class Raul extends Pond{
    double money = 5; // 每米5块钱

    public double getMoney(){
        return 2 * radiusRaul * PI * money;
    }
}