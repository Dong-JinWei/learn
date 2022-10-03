package hashMap;

import java.util.HashMap;
import java.util.Objects;

/**
 * @author 26465
 * @create 2022-02-08 15:51
 */
public class HashMapTest3 {
    public static void main(String[] args) {
        HashMap<Student, String> map = new HashMap<>();
        map.put(new Student(4, "dd"), "d4");
        map.put(new Student(5, "ee"), "e5");
        map.put(new Student(6, "ff"), "f6");


        System.out.println(map.containsKey(new Student(6, "ff")));
        map.remove(new Student(6, "ff"));
        System.out.println(map);
        System.out.println(map.containsKey(new Student(6, "ff")));
    }
}

class Student {
    int id;
    String name;

    public Student(int id, String name) {
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

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && Objects.equals(name, student.name);
    }

    public int hashCode() {
        return Objects.hash(id, name);
    }

}