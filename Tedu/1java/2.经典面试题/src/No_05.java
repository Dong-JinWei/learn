import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 26465
 * @create 2022-01-17 17:01
 */
public class No_05 {
    public static void main(String[] args) {
        int[] arr = {4, 1, 2, 4, 5, 7, 8 , -1 , -2};
        int k = 4;
        int[] res = smallestElements(arr, k);
        for (int num : res) {
            System.out.print(num + " ");
        }

    }

    public static int[] smallestElements(int[] arr, int n) {
        int[] res = new int[n];
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            res[i] = arr[i];
        }
        return res;
    }
}
