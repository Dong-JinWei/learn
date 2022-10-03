/*
输入两个正整数m和n，求其最大公约数和最小公倍数。
比如：12和20的最大公约数是4，最小公倍数是60；
说明：break关键字的使用
*/

import java.util.Scanner;
public class ForTest2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("请输入第一个正整数：");
        int m = in.nextInt();
        System.out.println("请输入第二个正整数：");
        int n = in.nextInt();

        //最大公约数，比小的数小
        int min = (m < n) ? m : n;

        for (int i = min; i > 0; i--){
            if (m % i == 0 && n % i == 0){
                System.out.println("最大公约数是：" + i);
                break;
            }
        }

        //最大公倍数，比大的大
        int max = (m > n) ? m : n;

        for (int i = max; i <= m * n;i++){
            if (i % m == 0 && i % n == 0){
                System.out.println("最小公倍数是：" + i);
                break;
            }
        }
    }
    
}
