public class Dog {
    String name;

    public void eat() {
        System.out.println("this = " + this);
        System.out.println(this.name + "吃东西");
    }

    public static void main(String[] args) {
        Dog dog1 = new Dog();
        dog1.name = "旺财";
        dog1.eat();
        System.out.println("dog1 = " + dog1);
        System.out.println();
        Dog dog2 = new Dog();
        dog2.name = "大黄";
        dog2.eat();
        System.out.println("dog2 = " + dog2);
    }
}