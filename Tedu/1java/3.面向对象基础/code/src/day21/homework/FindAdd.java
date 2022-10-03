package day21.homework;

/**
 * @author 26465
 * @create 2022-01-15 15:47
 */
public class FindAdd {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 4, 7, 11, 15};
        int n = 15;
        find(arr, n);
    }

    static void find(int[] arr, int n) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                if (n - arr[i] - arr[j] == 0) {
                    System.out.println(arr[i] + " " + arr[j]);
                }
            }
        }
    }
}
