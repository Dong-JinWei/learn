package day24.homework;

/**
 * @author 26465
 * @create 2022-01-19 17:16
 */
public class InstanceTest {
    public static void main(String[] args) {
        Person person = new Person();
        Student student = new Student();
        Graduated graduated = new Graduated();
        method(person);
        System.out.println();

        method(student);
        System.out.println();

        method(graduated);
        
    }

    public static void method(Person e){

        System.out.println(e.getInfo());

        if (e instanceof Graduated){
            System.out.println("a graduated student");
        }

        if (e instanceof Student){
            System.out.println("a student");
        }

        if(e instanceof Person){
            System.out.println("a person");
        }


    }

}

class Person {
    protected String name = "person";
    protected int age = 50;

    public String getInfo() {
        return "Name: " + name + "\n" + "age:" + age;
    }
}

class Student extends Person{
    protected String school = "pku";
    public String getInfo(){
        return "Name: " + name + "\n" + "age:" + age + "\nschool: " + school;
    }
}

class Graduated extends Student{
    public String major = "IT";
    public String getInfo(){
        return "Name: " + name + "\n" + "age:" + age + "\nschool: " + school + "\nmajor: " + major;
    }
}
