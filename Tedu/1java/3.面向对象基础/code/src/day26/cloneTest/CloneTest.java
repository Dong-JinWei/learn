package day26.cloneTest;

/**
 * @author 26465
 * @create 2022-01-20 20:07
 */
public class CloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Student student = new Student(200, "DIO");
        student.setMyDate(2022, 1, 20);
        System.out.println(student);

        Student student2 = student.clone();
        student2.setMyDate(2077, 12,13);
        System.out.println(student);
        System.out.println(student2);
    }
}

class Person implements Cloneable{
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Student implements Cloneable{
    private int age;
    private String name;
    private MyData myDate;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public void setMyDate( int year, int month, int day) {
        myDate = new MyData(year, month, day);
    }

    public Student clone() throws CloneNotSupportedException {
        Student cloned = (Student) super.clone();
        cloned.myDate = (MyData) myDate.clone();
        return cloned;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", myDate=" + myDate +
                '}';
    }
}
