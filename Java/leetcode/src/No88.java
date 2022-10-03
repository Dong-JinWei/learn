import java.util.Arrays;

public class No88 {
    public static void main(String[] args) {
        int[] num1 = new int[]{1,2,3,0,0,0};
        int[] num2 = new int[]{2,5,6};
        int m = 3;
        int n = 3;
        merge(num1,m, num2, n);
        System.out.println(Arrays.toString(num1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1.length == 0) {
            nums1 = nums2;
        }
        int one = 0;
        int two = 0;
        int index = 0;

        int[] temp = new int[m + n];

        while (index < n + m) {

            if (nums1[one] == 0) {
                temp[index] = nums2[two];
                two++;
                index++;
                continue;
            }
            if (nums1[one] <= nums2[two]) {
                temp[index] = nums1[one];
                one++;
                index++;
            } else {
                temp[index] = nums2[two];
                two++;
                index++;
            }
        }
        for(int i = 0; i < n+m; i++){
            nums1[i] = temp[i];
        }
        System.out.println("nums1" + Arrays.toString(nums1));
        System.out.println("nums2" + Arrays.toString(nums2));
        System.out.println("temp" + Arrays.toString(temp));

    }
}
