package day26;

/**
 * @author 26465
 * @create 2022-01-20 9:49
 */
public class Test {
    public static void main(String[] args) {
        Student student = new Student();
        System.out.println(student.toString());
        System.out.println(student);

    }
}

class Student{
    private String name = "DIO";
    private int age = 20;

    @Override
    public String toString() {
        return getClass().getName()+
                "name=" + name +
                ", age=" + age +
                '}';
    }
}