package ArrayListDemo;

import java.util.ArrayList;
import java.util.Comparator;

class Student {
    int id;
    String name;
    float score;

    public Student(int id, String name, float score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" + id +
                " " + name + ' ' +
                " " + score +
                '}';
    }
}

public class ArrayList02 {
    public static void main(String[] args) {
        ArrayList<Student> intList = new ArrayList<Student>();
        intList.add(new Student(1007, "aa", 51));
        intList.add(new Student(1003, "bb", 22));
        intList.add(new Student(1009, "cc", 63));
        intList.add(new Student(1001, "dd", 44));
        intList.add(new Student(1006, "ee", 15));
        intList.add(new Student(1005, "ff", 36));
        System.out.println(intList);


        intList.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.id - o2.id;
            }
        });
        System.out.println(intList);

        System.out.println(intList.subList(2, 4));


    }
}