/**
 * @author 26465
 * @create 2022-01-17 16:42
 * 3.求子数组的最大和
 * 题目：
 * 输入一个整形数组，数组里有正数也有负数。
 * 数组中连续的一个或多个整数组成一个子数组，每个子数组都有一个和。
 * 求所有子数组的和的最大值。要求时间复杂度为O(n)。
 * <p>
 * 例如输入的数组为1, -2, 3, 10, -4, 7, 2, -5，和最大的子数组为3, 10, -4, 7, 2，
 * 因此输出为该子数组的和18。
 */
public class No_03 {
    public static void main(String[] args) {
        int[] arr = new int[]{-1, -2, 3, 10, -4, 7, 2, -5};
        System.out.println("最大子数组的和为：" + MaxSubarray(arr));

    }


    public static int MaxSubarray(int[] arr) {
        int maxBegin = 0, maxEnd = arr.length, maxValue = arr[0];
        int begin, end, value;
        int i;

        for (i = 0, begin = 0, value = 0; i < arr.length; i++) {
            end = i;
            value = value + arr[i];
            if (value > maxValue) {
                maxBegin = begin;
                maxEnd = end;
                maxValue = value;
            }
            if (value < 0) {
                begin++;
                value = 0;
            }
        }
        return maxValue;
    }
}
