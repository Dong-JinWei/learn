package treeMap;

import java.util.ArrayList;
import java.util.Collections;

public class CollectionsTest {
    public static void main(String[] args) {
        ArrayList<StudentCompare> list = new ArrayList<StudentCompare>();
        list.add(new StudentCompare(2, "bb"));
        list.add(new StudentCompare(1, "aa"));
        list.add(new StudentCompare(5, "ee"));
        list.add(new StudentCompare(4, "dd"));
        list.add(new StudentCompare(7, "gg"));
        list.add(new StudentCompare(3, "cc"));
        list.add(new StudentCompare(6, "ff"));
        Collections.sort(list);
        System.out.println(list);

        int i = Collections.binarySearch(list, new StudentCompare(6, "ff"));
        System.out.println(i);

        Collections.reverse(list);
        System.out.println(list);

        Collections.fill(list, new StudentCompare(0, "xxx"));
        System.out.println(list);
    }
}
