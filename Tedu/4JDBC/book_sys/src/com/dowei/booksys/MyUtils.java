package com.dowei.booksys;

public class MyUtils {
    private MyUtils(){}

    public static boolean isNumber(String number) {
        boolean flag = true;
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            flag = false;
        }
        return flag;
    }

    public static boolean isNull(String str){
        boolean flag = false;
        if (null == str || "".equals(str.trim())){
            flag = true;
        }
        return flag;
    }
}
