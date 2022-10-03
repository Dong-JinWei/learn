import java.util.Arrays;

public class Merge88 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            for (int i = 0; i < nums2.length; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        if (n == 0) {
            return;
        }

        int[] temp = new int[m + n];
        int p = 0; // 指向nums1
        int q = 0; // 指向nums2
        int index = 0; // 指向新数组 temp

        while (p < m && q < n) {
            if (nums1[p] < nums2[q]) {
                temp[index++] = nums1[p++];
            } else {
                temp[index++] = nums2[q++];
            }
        }

        while (p < m) {
            temp[index++] = nums1[p++];
        }

        while (q < n) {
            temp[index++] = nums2[q++];
        }

        for (int i = 0; i < temp.length; i++) {
            nums1[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] { 4, 0, 0, 0, 0, 0 };
        int m = 1;
        int[] nums2 = new int[] { 1, 2, 3, 5, 6 };
        int n = 5;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}
