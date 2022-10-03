/**
 第20题：
 题目：输入一个表示整数的字符串，把该字符串转换成整数并输出。
 例如输入字符串"345"，则输出整数345。

 */
public class No_20 {
    public static void main(String[] args) {
        String str = "123";
        System.out.println(convertInteger(str));
    }

    public static int convertInteger(String str){
        int res = 0;

        for(int i = 0; i < str.length(); i++){
            int temp = str.charAt(i) - '0';
            res = res * 10 + temp;
        }

        return res;
    }
}
