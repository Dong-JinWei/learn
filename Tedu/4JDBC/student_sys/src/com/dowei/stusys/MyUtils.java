package com.dowei.stusys;

public class MyUtils {
    //构造方法私有化
    private MyUtils(){}

    //所有方法都是静态的
    //判断字符串是否是数字
    public static boolean isNumber(String number){
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
