/**
 * 如何对n个数进行排序，要求时间复杂度O(n)，空间复杂度O(1)
 */
public class No_49 {
    public static void main(String[] args) {
        int[] count = new int[65536];
        int[] ints = new int[]{100, 200, 300, 119, 0, 5, 7};

        for (int i = 0; i < ints.length; i++) {
            count[ints[i]]++;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                System.out.print(i + " ");
            }
        }

    }
}
