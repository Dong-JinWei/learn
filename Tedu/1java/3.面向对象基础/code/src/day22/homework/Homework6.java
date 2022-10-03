package day22.homework;

import java.util.Scanner;

/**
 * @author 26465
 * @create 2022-01-17 12:24
 * 6、使用charAt实现输入一个表示整数的字符串，把该字符串转换成整数并输出。
 * 例如输入字符串"345"，则输出整数345。
 */
public class Homework6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入数字字符串：");
        String str = in.next();
        System.out.println("转换为数字之后是："+conversionInt(str));


    }

    public static int conversionInt(String str) {
        int res = 0;
        int temp = 0;

        for (int i = 0; i < str.length(); i++) {
            temp = str.charAt(i) - '0';
            res = res * 10 + temp;
        }

        return res;
    }
}
