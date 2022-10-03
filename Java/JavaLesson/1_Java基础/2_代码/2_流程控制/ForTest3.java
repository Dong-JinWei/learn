/*
输出所有的水仙花数，所谓的水仙花数是指3位数，其各个位上数字立方和等于其本身。
例如：153 = 1*1*1 + 3*3*3 + 5*5*5

*/

public class ForTest3 {
    public static void main(String[] args) {

        int g, s, b;
        for (int i = 100; i < 1000; i++) {

            g = i % 10;
            s = i / 10 % 10;
            b = i / 100;

            if (i == g * g * g + s * s * s + b * b * b) {
                System.out.println("" + b + s + g);
            }

        }

    }

}
