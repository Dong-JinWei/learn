/**
 第14题：
 题目：输入一个已经按升序排序过的数组和一个数字，
 在数组中查找两个数，使得它们的和正好是输入的那个数字。
 要求时间复杂度是O(n)。如果有多对数字的和等于输入的数字，输出任意一对即可。
 例如输入数组1、2、4、7、11、15和数字15。由于4+11=15，因此输出4和11。

 */
public class No_14 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 4, 7, 11, 15};
        int n = 15;

        int[] a;
        a = findSum(arr, n);
        for (int num : a ) {
            System.out.println(num);
        }
    }

    public static int[] findSum(int[] arr, int n) {
        int fist = 0;
        int end = arr.length - 1;

        for (int i = 0; i < end; i++) {
            if (arr[fist] + arr[end] < n) {
                fist++;
            } else if (arr[fist] + arr[end] > n) {
                end--;
            } else {
                return new int[]{arr[fist], arr[end]};
            }
        }
        return null;
    }
}
