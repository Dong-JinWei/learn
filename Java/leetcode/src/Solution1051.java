public class Solution1051 {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 4, 2, 1, 3 };
        heightChecker(nums);

    }

    public static int heightChecker(int[] heights) {
        int[] arr = new int[101];
        for (int height : heights) {
            arr[height]++;
        }
        int count = 0;
        for (int i = 1, j = 0; i < arr.length; i++) {
            while (arr[i]-- > 0) {
                if (heights[j++] != i)
                    count++;
            }
        }
        return count;
    }
}