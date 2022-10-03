package com.danei.lesson01;

/**
 * 控制语句
 * 分支选择 if，else
 * 循环 for() while()
 */
public class Controller {
    public static void main(String[] args) {
        int score;

        score = 76;

//        if (score >= 60){
//            System.out.println("及格");
//        } else {
//            System.out.println("不及格");
//        }


//        //for循环打印三角形
//        for (int i = 1; i < 7; i++){
//            for (int j = 0 ; j < i ; j++){
//                System.out.print("*\t");
//            }
//            System.out.println();
//        }

        //调用countNum() 方法
//        System.out.println("1+2+3...+100 = " + countNum(100));


    }
    public static int countNum(int n){
        /**
         * 计算1+2+3+4.。。。+n
         */
        int sum = 0;
        int i = 1;
        while(i < n) {
            sum += i;
            i++;
        }
        return sum;
    }
}
