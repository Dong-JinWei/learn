import java.util.ArrayList;
import java.util.List;

/**
 30.在从1到n的正数中1出现的次数
 题目：输入一个整数n，求从1到n这n个整数的十进制表示中1出现的次数。

 例如输入12，从1到12这些整数中包含1 的数字有1，10，11和12，1一共出现了5次。
 分析：这是一道广为流传的google面试题。
 */
public class No_30 {
    public static void main(String[] args) {
        int n = 12;
        System.out.println(countOne(12));
    }

    public static int countOne(int n){
        int count = 0;
        String[] str = new String[n];
        for (int i = 0; i < n; i++){
            str[i] = "" + (i + 1);
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < str[i].length(); j++){
                if (str[i].charAt(j) == '1'){
                    count++;
                }
            }
        }
        return count;
    }
}
