package hashSet;

import java.util.HashSet;
import java.util.Objects;

public class HashSet02 {
    public static void main(String[] args) {
        HashSet<Student> set = new HashSet<Student>();
        set.add(new Student(1001, "aa"));
        set.add(new Student(1002, "bb**"));
        set.add(new Student(1003, "cc"));
        set.add(new Student(1004, "d++d"));
        set.add(new Student(1005, "ee"));
        System.out.println(set);
        set.remove(new Student(1003, "cc"));
        System.out.println(set);
        System.out.println(set.contains(new Student(1001, "aa")));
    }
}

class Student{
    int id;
    String name;
    public Student(int id, String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}