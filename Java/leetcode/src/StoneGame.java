public class StoneGame {

    public static void main(String[] args) {
        int[] arr = new int[] { 7, 7, 12, 16, 41, 48, 41, 48, 11, 9, 34, 2, 44, 30, 27, 12, 11, 39, 31, 8, 23, 11, 47,
                25, 15, 23, 4, 17, 11, 50, 16, 50, 38, 34, 48, 27, 16, 24, 22, 48, 50, 10, 26, 27, 9, 43, 13, 42, 46,
                24 };
        System.out.println(stoneGame(arr));
    }

    public static boolean stoneGame(int[] piles) {
        int sum = 0;
        for (int i : piles) {
            sum += i;
        }
        int p1 = maxScore(piles, 0, piles.length - 1);

        return p1 > sum - p1;

    }

    public static int maxScore(int[] arr, int l, int r) {
        if (l == r) {
            return arr[l];
        }
        int sLeft = 0;
        int rRight = 0;
        if (r - l == 1) {
            sLeft = arr[l];
            rRight = arr[r];
        }
        if (r - l >= 2) {
            sLeft = arr[l] + Math.min(maxScore(arr, l + 2, r), maxScore(arr, l + 1, r - 1));
            rRight = arr[r] + Math.min(maxScore(arr, l + 1, r - 1), maxScore(arr, l, r - 2));
        }

        return Math.max(sLeft, rRight);
    }
}
