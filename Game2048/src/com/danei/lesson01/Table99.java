package com.danei.lesson01;

/**
 * 打印99乘法表
 */
public class Table99 {
    public static void main(String[] args) {

        for (int i = 1; i <= 9; i++){
            for(int j = 1; j <= i; j++)
            System.out.printf("%d*%d=%d\t",j, i, j*i);
            System.out.println();
        }
        System.out.println();
    }
}
