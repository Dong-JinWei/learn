package day22.homework;

/**
 * @author 26465
 * @create 2022-01-17 12:04
 * 1、使用charAt方法颠倒一个字符串。如将“abcdef“字符串，转换为”fedcba“
 */
public class Homework1 {
    public static void main(String[] args) {
        String str = "hello world";
        System.out.println("反转前的字符串：" + str);
        str = reverse(str);
        System.out.println("反转后的字符串：" + str);
    }

    public static String reverse(String str) {
        StringBuffer buffer = new StringBuffer();

        for (int i = str.length() - 1; i >= 0; i--) {
            buffer.append(str.charAt(i));
        }
        return buffer.toString();
    }


}
