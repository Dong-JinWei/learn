package day21.homework;

/**
 * @author 26465
 * @create 2022-01-15 18:02
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr = new int[]{3,2,4};
        int target = 6;

        int[] temp = twoSum(arr, target);

        for ( int n: temp) {
            System.out.println(n);
        }
    }

    static int[] twoSum(int[] nums, int target) {
        int j = 1;
        int i = 0;
        int maxArea = nums.length - 1;
        while (nums[i] + nums[j] != target){
            if(j == maxArea){
                i++;
                j = i;
            }
            j++;
        }
        return new int[]{i,j};
    }
}
