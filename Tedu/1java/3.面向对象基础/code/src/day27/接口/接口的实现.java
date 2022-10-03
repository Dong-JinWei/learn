package day27.接口;

/**
 * @author 26465
 * @create 2022-01-21 17:34
 */
public class 接口的实现 {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Dog dog = new Dog();
        cat.eat();
        cat.move();
        cat.color("Black");
        dog.eat();
        dog.move();
        dog.color("Red");
    }

}

interface Animal{ // 动物接口
    public void eat(); // 吃
    public void move(); // 移动
}

interface ColorAnimal extends Animal{ //继承动物接口
    public void color();
}

class Cat implements Animal{ //Cat类 实现接口
    public void eat(){
        System.out.println("Cat eat");
    }

    public void move(){
        System.out.println("Cat move");
    }

    public void color(String color){
        System.out.println("Cat " + color);
    }
}

class Dog implements Animal{
    public void eat(){
        System.out.println("Dog eat");
    }
    public void move(){
        System.out.println("Dog move");
    }

    public void color(String color){
        System.out.println("Dog " + color);
    }
}