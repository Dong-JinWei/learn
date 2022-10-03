package day22.homework;

/**
 * @author 26465
 * @create 2022-01-17 14:12
 * 5、使用charAt实现在一个字符串中找到第一个只出现一次的字符。
 * 如输入abaccdeff，则输出b。
 */
public class Homework5 {
    public static void main(String[] args) {
        String str = "abaccdeff";
        System.out.println(findChar(str));
    }

    public static char findChar(String str){
        if (str == null || str.length() == 0){
            return '0';
        }
        char[] chars = new char[26];

        for (int i = 0; i < str.length(); i++) {
            chars[str.charAt(i) - 'a']++;
        }
        for (int i = 0; i < str.length(); i++) {
            if(chars[str.charAt(i) - 'a'] == 1){
                return str.charAt(i);
            }
        }
        return '0';
    }
}
