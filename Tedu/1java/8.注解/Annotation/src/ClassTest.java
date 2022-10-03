import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassTest {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<Student> student = (Class<Student>) Class.forName("Student");
        Class<Student> studentClass = Student.class;
        System.out.println(studentClass);

        Student student1 = new Student();
        Class<Student> aClass = (Class<Student>) student1.getClass();
        System.out.println(aClass);
        System.out.println(aClass.getName());

        Student student2 = aClass.newInstance();
        System.out.println(student2);

        Method f = aClass.getMethod("f", int.class, float.class, String.class);
        f.invoke(student1, 1, 2.1f, "dd");

        Method[] methods = aClass.getMethods();
        System.out.println(methods.length);

    }
}

class Student{
    int id;
    String name;
    float score;

    public Student() {
        System.out.println("无参");
    }

    public Student(int id, String name, float score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public void f(int a, float b, String c){
        System.out.println("f(3个参数)==");
    }

    private void f(float b, String c){
        System.out.println("f(2个参数)==");
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}