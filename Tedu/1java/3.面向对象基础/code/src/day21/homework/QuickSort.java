package day21.homework;

/**
 * @author 26465
 * @create 2022-01-15 16:23
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{29, 47, 2, 97, 4, 92, 0, 347, 12};
        System.out.println("排序前");
        printArrays(arr);

        quickSort(arr,0, arr.length - 1);
        System.out.println("排序后");
        printArrays(arr);

    }

    static int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partition = partition(arr, left, right);
            quickSort(arr, left, partition - 1);
            quickSort(arr, partition + 1, right);
        }
        return arr;
    }

    static int partition(int[] arr, int left, int right) {
        int pivot = left;
        int index = pivot + 1;

        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void printArrays(int[] arr) {

        for (int n : arr) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
}
