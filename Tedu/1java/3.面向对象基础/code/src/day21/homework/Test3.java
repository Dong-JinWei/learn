package day21.homework;

/**
 * @author 26465
 * @create 2022-01-15 18:19
 */
public class Test3 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 7, 9, 3, 2, 10, 4, 8, 12};
        Test3.sort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void sort(int[] arr, int left, int right) {
        int i, j, temp, t;
        i = left;
        j = right;
        if(i > j){
            return;
        }
        temp = arr[i];

        while (i < j) {
            while (temp <= arr[j] && i < j) {
                j--;
            }
            while (temp >= arr[i] && i < j) {
                i++;
            }
            if (i < j) {
                t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        arr[left] = arr[i];
        arr[i] = temp;
        if (i == j) {
            sort(arr, left, j - 1);
            sort(arr, j + 1, right);
        }
    }
}
