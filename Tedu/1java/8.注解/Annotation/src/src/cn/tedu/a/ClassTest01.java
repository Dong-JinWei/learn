package cn.tedu.a;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Student{
    public int id;
    public String name;
    public float score;

    public Student(){
        System.out.println("Student()");
    }

    public Student(int id, String name, float score) {
        this.id = id;
        this.name = name;
        this.score = score;
        System.out.println("Student(int id, String name, float score)");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public void show(){
        System.out.println("student show");
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
    public void f(int a, float b, String c){
        System.out.println("f(3个参数)==");
    }
    public void f(float b, String c){
        System.out.println("f(2个参数)==");
    }
    public void g(float b, String c){
        System.out.println("g(2个参数)==");
    }
}
public class ClassTest01 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //Class<Student> c = (Class<Student>)Class.forName("cn.tedu.a.Student");
        //Class<Student> c = Student.class;
        Student s = new Student();
        Class<Student> c = (Class<Student>)s.getClass();
        System.out.println(c.getName());

        Student student = c.newInstance();
        System.out.println(student);

        Method f1 = c.getMethod("f", int.class, float.class, String.class);
        f1.invoke(s, 1, 1.0f, "aa");

        Method[] methods = c.getMethods();
        System.out.println(methods.length);
    }
}
