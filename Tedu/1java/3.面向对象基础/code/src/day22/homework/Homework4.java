package day22.homework;

/**
 * @author 26465
 * @create 2022-01-17 14:22
 * 4、使用charAt方法判断字符串中单词的个数，单词之间用一个或多个空格分割。
 * 如”aa b ccc  ddd   eee”，有5个单词。
 */
public class Homework4 {
    public static void main(String[] args) {
        String str = "aa b ccc   ddd   eee";
        System.out.println("有 " + findWords(str) + " 个单词");
    }

    public static int findWords(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        // 将任意多的空格替换成一个空格
        str = str.replaceAll("\\s+", " ");
        int count = 1;
        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == ' ') {
                count++;
            }
        }

        return count;
    }
}
