package com.dowei.stusys;

import org.testng.annotations.Test;

public class TestMyUtils {

    @Test
    public void testIsNumber(){
        String str = "123";
        System.out.println(MyUtils.isNumber(str));
    }
}
