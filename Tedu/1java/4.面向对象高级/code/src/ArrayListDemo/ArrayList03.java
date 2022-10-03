package ArrayListDemo;

import java.util.ArrayList;

/**
 * @author 26465
 * @create 2022-01-27 17:01
 */
public class ArrayList03 {
    public static void main(String[] args) {
        MyArrayList<Student> intList = new MyArrayList<Student>();
        intList.add(new Student(1007, "aa", 51));
        intList.add(new Student(1003, "bb", 22));
        intList.add(new Student(1009, "cc", 63));
        intList.add(new Student(1001, "dd", 44));
        intList.add(new Student(1006, "ee", 15));
        intList.add(new Student(1005, "ff", 36));
        System.out.println(intList);
        intList.removeRange(1, 5);
        System.out.println(intList);

    }
}

class MyArrayList<E> extends ArrayList<E> {

    @Override
    public void removeRange(int fromIndex, int toIndex) {
        super.removeRange(fromIndex, toIndex);
    }
}