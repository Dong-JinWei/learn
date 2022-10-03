import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2, 1 };
        System.out.print("排序前");
        System.out.println(Arrays.toString(nums));
        nums = bubbleSort(nums);
        System.out.print("排序后");
        System.out.println(Arrays.toString(nums));
    }

    public static int[] bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        return nums;
    }
}