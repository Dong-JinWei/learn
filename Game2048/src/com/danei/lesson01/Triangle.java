package com.danei.lesson01;

/**
 * 控制台输出等腰三角形
 */

public class Triangle {
    public static void main(String[] args) {

        int n = 6;  //设置行数

/* 实现思路 当n=6时
     *       //第一层，1个，5个空格
    ***      //第二次，3个，4给空格
   *****      //第三层，5个，3个空格
  *******      //第四层，7个，2个空格
 *********       //第五层，9个，1个空格
***********      //第六层，11个，0个空格

最外层循环控制行数，共有6行，所以 for(i = 1; i <= n; i++){
    控制空格的数量，空格数 = n - 1，所以 for(m = 1; m <= n-1; m++)
        输出空格
    控制星星的个数，星星个数 = n*2-1，所以 for(j = 1; j <= n*2-1; j++){
        输出星星
    }
    输出空行
}
*/
        for (int i = 1; i <= n; i++){
            for (int m = 1; m <= n - i; m++)
                System.out.print(" ");
            for(int j = 1; j <= i * 2 - 1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
