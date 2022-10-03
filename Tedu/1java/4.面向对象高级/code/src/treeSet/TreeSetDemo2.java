package treeSet;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author 26465
 * @create 2022-01-28 17:36
 */
public class TreeSetDemo2 {
    public static void main(String[] args) {
        TreeSet<Student> set = new TreeSet<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.id > o2.id)
                    return 1;
                if (o1.id < o2.id)
                    return -1;
                if (o1.id == o2.id && o1.name.equals(o2.name))
                    return 0;
                else
                    return 1;
            }
        });

        set.add(new Student(1007, "aa"));
        set.add(new Student(1005, "bb"));
        set.add(new Student(1006, "cc"));
        set.add(new Student(1001, "dd"));
        set.add(new Student(1003, "ee"));
        set.add(new Student(1002, "ff"));
        set.add(new Student(1008, "gg"));
        System.out.println(set);
        System.out.println(set.contains(new Student(1008, "gf")));
    }
}

//class Student implements Comparable<Student>{
class Student{

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

//    @Override
//    public int compareTo(Student o) {
//        if (this.id > o.id)
//            return 1;
//        if (this.id < o.id)
//            return -1;
//        if (this.id == o.id && this.name.equals(o.name))
//            return 0;
//        else
//            return 1;
//    }
}