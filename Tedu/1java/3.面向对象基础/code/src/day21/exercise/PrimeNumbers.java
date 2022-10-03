package day21.exercise;

/**
 * @author 26465
 * @create 2022-01-15 14:11
 */
public class PrimeNumbers {
    public static void main(String[] args) {
        final int LENGTH = 100;
        int[] arr = new int[LENGTH + 1];

        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i <= Math.sqrt(LENGTH); i++) {
            if (arr[i] == 0) {
                for (int j = i * 2; j < LENGTH; j = j + i) {
                    arr[j] = 1;
                }
            }
        }

        for (int i = 0; i < LENGTH; i++) {
            if (arr[i] == 0) {
                System.out.print(i + " ");

            }
        }

    }

}
