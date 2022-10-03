import java.util.Arrays;

public class Solution75 {
    public static void sortColors(int[] nums) {
        int zero = 0;
        int one = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zero++;
            } else if (nums[i] == 1) {
                one++;
            }
            nums[i] = 2;
        }

        int i = 0;
        for (; i < zero; i++) {
            nums[i] = 0;
        }
        for (; i < one + zero; i++) {
            nums[i] = 1;
        }
    }

    public static void main(String[] args) {
        int[] nums = { 2, 0, 2, 1, 1, 0 };
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}