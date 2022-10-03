import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[] { 1, 52, 34, -4, 5, 62, 7, 8, 9, 0 };
        System.out.println("快速排序前：" + Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println("快速排序后：" + Arrays.toString(arr));
    }

    public static void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int key = nums[left];
            int i = left;
            for (int j = left + 1; j <= right; j++) {
                if (key > nums[j]) {
                    swap(nums, j, ++i);
                }
            }
            nums[left] = nums[i];
            nums[i] = key;
            quickSort(nums, left, i - 1);
            quickSort(nums, left + 1, right);
        }
    }

    private static void swap(int[] nums, int j, int i) {
        if (i != j) {
            nums[i] ^= nums[j];
            nums[j] ^= nums[i];
            nums[i] ^= nums[j];
        }
    }

}
