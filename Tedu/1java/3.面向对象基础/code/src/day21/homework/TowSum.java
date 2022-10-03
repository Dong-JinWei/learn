package day21.homework;

import java.util.Arrays;

/**
 * @author 26465
 * @create 2022-01-15 17:32
 */
public class TowSum {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 4};
        towSum(arr, 6);

    }

    static void towSum(int[] arr, int n) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            if ((arr[left] + arr[right]) < n) {
                left++;
            } else if ((arr[left] + arr[right]) > n) {
                right--;
            } else {
                break;
            }

        }
        if (left == right){
            System.out.println("没有");
        }
        System.out.println(arr[left] +" " + arr[right]);
//        int[] temp = new int[2];
//        temp[0] = arr[left];
//        temp[1] = arr[right];
//
//        return temp;
    }
}
