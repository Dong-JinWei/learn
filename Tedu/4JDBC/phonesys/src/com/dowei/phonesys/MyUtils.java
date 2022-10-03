package com.dowei.phonesys;

public class MyUtils {
    private MyUtils() {
    }

    public static boolean isNumber(String str) {
        boolean flag = true;
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            flag = false;
        }
        return flag;
    }

    public static boolean isDouble(String str) {
        boolean flag = true;
        try {
            Double.parseDouble(str);
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    public static boolean isNull(String str) {
        boolean flag = false;
        if (null == str || "".equals(str.trim())) {
            flag = true;
        }
        return flag;
    }
}
