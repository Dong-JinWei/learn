package linkedHashSet;

import java.util.LinkedHashSet;

public class LinkedHashSet01 {
    public static void main(String[] args) {
        LinkedHashSet<String> set = new LinkedHashSet<>();
        set.add("aa");
        set.add("bb===");
        set.add("cc");
        set.add("dd****");
        set.add("ee");
        set.add("ef");
        set.add("ff");
        System.out.println(set);
    }

}
