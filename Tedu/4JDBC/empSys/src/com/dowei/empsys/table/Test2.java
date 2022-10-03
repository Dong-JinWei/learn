package com.dowei.empsys.table;

import java.util.ArrayList;

public class Test2 {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("abc");
        strings.add("123");
        strings.add("test");

        strings.forEach(System.out::println);
        System.out.println("=================");
        strings.forEach(string -> {
            System.out.println(strings);
        });

    }
}
