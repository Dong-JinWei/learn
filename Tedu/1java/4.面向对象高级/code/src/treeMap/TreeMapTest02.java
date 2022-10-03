package treeMap;

import java.util.Comparator;
import java.util.TreeMap;

public class TreeMapTest02 {
    public static void main(String[] args) {
        TreeMap<StudentCompare, String> treeMap = new TreeMap<>();
        treeMap.put(new StudentCompare(2, "bb"), "2b");
        treeMap.put(new StudentCompare(1, "aa"), "1a");
        treeMap.put(new StudentCompare(5, "ee"), "5e");
        treeMap.put(new StudentCompare(4, "dd"), "4d");
        treeMap.put(new StudentCompare(7, "gg"), "7g");
        treeMap.put(new StudentCompare(3, "cc"), "3c");
        treeMap.put(new StudentCompare(6, "ff"), "6f");
        System.out.println(treeMap);

        TreeMap<Student, String> map = new TreeMap<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.id > o2.id){
                    return 1;
                }else if (o1.id < o2.id){
                    return -1;
                }else{
                    return o1.name.compareTo(o2.name);
                }
            }
        });
        map.put(new Student(2, "bb"), "2b");
        map.put(new Student(1, "aa"), "1a");
        map.put(new Student(5, "ee"), "5e");
        map.put(new Student(4, "dd"), "4d");
        map.put(new Student(7, "gg"), "7g");
        map.put(new Student(3, "cc"), "3c");
        map.put(new Student(6, "ff"), "6f");
        System.out.println(map);
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
}

class StudentCompare implements Comparable<StudentCompare>{
    int id;
    String name;

    public StudentCompare(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "StudentCompare{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(StudentCompare o) {
        if (id > o.id){
            return 1;
        }else if (id < o.id){
            return -1;
        }else{
            return name.compareTo(o.name);
        }
    }
}