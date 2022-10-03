package day22.homework;

/**
 * @author 26465
 * @create 2022-01-17 12:20
 * 2、使用字符串数组中保存文件名，使用subString方法将 .txt 的文件打印。
 */
public class Homework2 {
    public static void main(String[] args) {
        String[] str = {"dowei.txt","123.md", "djw.html"};
        for (int i = 0; i < str.length; i++) {
                int start = subTxtIndex(str[i]);
                int end = str[i].length();
                if(str[i].substring(start, end).equals(".txt")){
                    System.out.println(str[i]);
            }
        }
    }

    public static int subTxtIndex(String str) {
        for (int i = str.length() - 1; i > 0; i--) {
            if (str.charAt(i) == '.') {
                return i;
            }
        }
        return -1;
    }
}
