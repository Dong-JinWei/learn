package com.dowei.phonesys;

import org.testng.annotations.Test;

public class TestMyUtils {
    @Test
    public void test(){
        String str = "124.1";
        boolean aNull = MyUtils.isNull(str);
        System.out.println(aNull);
        System.out.println(MyUtils.isNumber(str));
        System.out.println(MyUtils.isDouble(str));
    }
}
