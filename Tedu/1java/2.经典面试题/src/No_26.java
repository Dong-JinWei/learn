/**
 * 题目：
 * 定义字符串的左旋转操作：把字符串前面的若干个字符移动到字符串的尾部。
 * <p>
 * 如把字符串abcdef左旋转2位得到字符串cdefab。请实现字符串左旋转的函数。
 * 要求时间对长度为n的字符串操作的复杂度为O(n)，辅助内存为O(1)。
 */
public class No_26 {
    public static void main(String[] args) {
        String str = "abcdef";
        int n = 2;
        System.out.println(moveLeft(str, n));
    }

    public static String moveLeft(String s, int n) {
        String res = "";
        for (int i = n; i < s.length(); i++) {
            res += s.charAt(i);
        }
        for (int i = 0; i < n; i++) {
            res += s.charAt(i);
        }
        return res;
    }
}
