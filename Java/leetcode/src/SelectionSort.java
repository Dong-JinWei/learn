import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = new int[] { 1, 52, 34, -4, 5, 62, 7, 8, 9, 0 };
        System.out.println("选择排序前：" + Arrays.toString(arr));
        selectionSort(arr);
        System.out.println("选择排序后：" + Arrays.toString(arr));

    }

    public static void selectionSort(int[] arr) {
        int curr = 0;
        int min = 0;
        int i;
        while (curr < arr.length) {
            for (i = curr; i < arr.length; i++) {
                if (arr[i] < arr[min]) {
                    min = i;
                }
            }

            int temp = arr[curr];
            arr[curr] = arr[min];
            arr[min] = temp;
            curr++;
            min = curr;
        }
    }
}