import java.util.Arrays;

public class KMP {
    public static void main(String[] args) {
        char[] pattern = new char[] { 'A', 'B', 'C', 'D', 'A', 'B' };
        int[] next = new int[pattern.length];
        getNext(pattern, next);
        System.out.println(Arrays.toString(next));

    }

    public static void getNext(char[] pattern, int[] next) {
        next[0] = -1;
        int i = 0, j = -1;

        while (i < pattern.length) {
            if (j == -1) {
                i++;
                j++;
            } else if (pattern[i] == pattern[j]) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
    }
}
