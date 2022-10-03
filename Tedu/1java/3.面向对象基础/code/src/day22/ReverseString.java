package day22;

/**
 * @author 26465
 * @create 2022-01-17 11:41
 */
public class ReverseString {
    public static void main(String[] args) {
        String str = "hello world";
        System.out.println("反转前的字符串：" + str);
        str = reverse(str);
        System.out.println("反转后的字符串：" + str);

    }

    public static String reverse(String str) {
        if (str.length() == 0 || str == null) {
            return "";
        }
        char[] chars = str.toCharArray();
        int mid = chars.length / 2;

        for (int i = 0, j = chars.length - 1; i < mid; i++, j--) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        str = String.copyValueOf(chars);
        return str;
    }
}
