package com.dowei.empsys.utils;

import javax.swing.*;

public class MyUtils {
    private MyUtils(){
    }

    public static boolean isLength(String str){
        boolean flag = false;
        if ("".equals(str.trim()) || str.length() == 0){
            return false;
        }
        if (str.length() >= 1 && str.length() <= 10){
            flag = true;
        }
        return flag;
    }


    public static boolean isEmpty(String str){
        boolean flag = false;
        if ("".equals(str.trim()) && str.length() == 0){
            flag = true;
        }
        return flag;
    }

    public static boolean isDouble(String str){
        boolean flag = false;
        try {
            Double.parseDouble(str);
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
}
