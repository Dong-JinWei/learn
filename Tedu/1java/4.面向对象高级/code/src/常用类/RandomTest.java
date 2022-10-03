package 常用类;

import java.util.Random;

/**
 * @author 26465
 * @create 2022-01-26 11:46
 */
public class RandomTest {
    public static void main(String[] args) {
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            System.out.print(random.nextInt(10) + " ");
        }
        System.out.println();

        random.setSeed(1);
        for (int i = 0; i < 10; i++) {
            System.out.print(random.nextInt(10) + " ");
        }
        //5 8 7 3 4 4 4 6 8 8
        System.out.println();

        random.setSeed(2);
        for (int i = 0; i < 10; i++) {
            System.out.print(random.nextInt(10) + " ");
        }
        //8 2 0 7 9 0 6 9 7 8
        System.out.println();

    }
}
