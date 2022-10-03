package com.dowei.chapter9.map;

import java.util.HashMap;

public class MapTest {
    public static void main(String[] args) {
        HashMap<String, String> staff = new HashMap<>();

        staff.put("1", "Tom");
        staff.put("2", "Harry");
        staff.put("3", "Gary");
        staff.put("4", "Cruz");

        System.out.println(staff);

        staff.remove("2");
        staff.put("4", "Amy Lee");
        System.out.println(staff.get("3"));

        staff.forEach((k, v) -> System.out.println("key=" + k + ", value=" + v));


    }
}
