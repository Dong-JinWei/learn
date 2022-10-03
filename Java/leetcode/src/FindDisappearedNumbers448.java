import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumbers448 {
    public static void main(String[] args) {
        int[] nums = new int[] { 4, 3, 2, 7, 8, 2, 3, 1 };
        System.out.println(findDisappearedNumbers(nums));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
         for (int num : nums) {
            int x = (num - 1) % n;
            nums[x] += n;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= n) {
                list.add(i + 1);
            }
        }
        return list;
    }
}
