package day19面向对象_快速排序;

/**
 * @author 26465
 * @create 2022-01-09 16:01
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{12, 412, 34, 123, 42, 55, 867, 584, 53, 45, 2, 3, 4};
        System.out.print("原始数组为：");
        printArrays(arr);

        System.out.print("快速排序后的数组为：");
        arr = quickSort(arr, 0, arr.length - 1);
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
            if (arr[i] < arr[pivot]) {// 把比pivot小的值全部放到他的右边
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1); // 把pivot移动到比他小的数的右边
        return index - 1; //返回pivot的下标
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
