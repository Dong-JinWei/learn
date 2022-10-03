/**
 第17题：
 题目：在一个字符串中找到第一个只出现一次的字符。如输入abaccdeff，则输出b。

 */
public class No_17 {
    public static void main(String[] args) {
        String str = "abaccdeff";

        System.out.println("原字符串：" + str);

        System.out.println("第一次只出现一次的字符：" + findOne(str));
    }

    public static char findOne(String str){
        int[] arr = new int[26];

        for(int i = 0; i < str.length(); i++){
            arr[str.charAt(i) - 'a']++;
        }
        for(int i  = 0; i < arr.length; i++){
            if (arr[i] == 1){
                return str.charAt(i);
            }
        }
        return ' ';
    }
}
