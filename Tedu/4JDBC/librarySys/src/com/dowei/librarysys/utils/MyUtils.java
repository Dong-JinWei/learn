package com.dowei.librarysys.utils;

public class MyUtils {
    private MyUtils(){

    }


    public static boolean isInt(String str){
        boolean flag = false;

        try{
            Integer.parseInt(str);
            flag = true;
        }catch (Exception e){
            flag = false;
        }
        return flag;
    }
}
