package com.dowei.empsys.table;

public interface A {
    String UP_TIME = "6:00";
    String DOWN_TIME = "18:20";
    void study();
    void exam();
    default void write(){
        System.out.println("写作业");
    }

    default  void sports(){
        System.out.println("运动会");
    }

}
