package day21.homework;

/**
 * @author 26465
 * @create 2022-01-15 16:12
 */
public class MaxSub {
    public static void main(String[] args) {
        int[] arr = new int[]{1, -2, 3, 10, -4, 7, 2, -5};
        System.out.println("最大子数组的和是：" + MaximumSubarray(arr));
    }

    static int MaximumSubarray(int[] arr) {
        int maxBegin = 0, maxEnd = 0, max = arr[0];

        int begin, end, value;
        int i;
        for (i = 0, begin = 0, value = 0; i < arr.length; i++) {
            end = i;
            value = value + arr[i];
            if (value > max) {
                maxBegin = begin;
                maxEnd = end;
                max = value;
            }
            if (value < 0) {
                begin = begin + 1;
                value = 0;
            }

        }
        return max;
    }

}
