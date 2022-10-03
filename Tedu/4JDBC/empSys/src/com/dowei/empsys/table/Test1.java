package com.dowei.empsys.table;

import java.util.ArrayList;

public class Test1 {
    public static void main(String[] args) {
        ArrayList<ArrayList<String>> school = new ArrayList<>();

        ArrayList<String> class1 = new ArrayList<>();
        ArrayList<String> class2 = new ArrayList<>();
        ArrayList<String> class3 = new ArrayList<>();

        class1.add("张三");class1.add("张三2");class1.add("张三3");
        //准备2班的学生
        class2.add("李四");class2.add("李四2");class2.add("李四3");
        //准备3班的学生
        class3.add("王五");class3.add("王五2");class3.add("王五3");
        class3.add("王五4");class3.add("王五5");class3.add("王五6");


        school.add(class1);
        school.add(class2);
        school.add(class3);

        //System.out.println(school);
        for(ArrayList<String> classes : school){
            System.out.println(classes);
            //for(String stu : classes){
            //    System.out.println(stu);
            //}
        }
        System.out.println(school.get(1).get(2));//李四3
        System.out.println(school.get(0).get(2));//张三3
        System.out.println(school.get(2).get(0));//王五
        System.out.println(school.get(2).get(5));//王五6


    }
}
