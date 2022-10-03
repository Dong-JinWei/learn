package day22.homework;

/**
 * @author 26465
 * @create 2022-01-17 15:10
 * 3、使用splite颠倒一个句子中的词的顺序
 * 如“aa bb ccc ddd eee“字符串，转换为“eee ddd ccc bb aa“
 */
public class Homework3 {
    public static void main(String[] args) {
        String str = "aa bb ccc ddd eee";
        System.out.println(splWord(str));
    }

    public static String splWord(String str) {
        StringBuffer buffer = new StringBuffer();
        String[] s = str.split(" ");
        for (int i = s.length - 1; i >= 0; i--) {
            buffer.append(s[i] + " ");
        }

        return buffer.toString();
    }
}
