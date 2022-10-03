package hemowork;

import java.util.Arrays;

public class 第一题 {
    public static void main(String[] args) {
        int[] arr = {10, 74, 101, 34, 71, 0, 6};

        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr) {
        int start;
        int min = 0;

        for (start = 0; start < arr.length; start++) {
            min = start;
            for (int j = start; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            int temp = arr[start];
            arr[start] = arr[min];
            arr[min] = temp;
        }
    }
}
