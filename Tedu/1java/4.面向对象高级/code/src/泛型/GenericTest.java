package 泛型;

/**
 * @author 26465
 * @create 2022-01-26 11:54
 */

public class GenericTest {
    public static void main(String[] args) {
        Student<String> stu1 = new Student<>();

        stu1.name = "DIO";
        stu1.age = "200";
        stu1.show();

        Student<Integer> stu2 = new Student<>();

        stu2.name = 1007;
        stu2.age = 26;
        stu2.show();

    }
}

class Student<E>{
    E name;
    E age;
    void show(){
        System.out.println("name: " + name);
        System.out.println("age: " + age);
    }
}