/**
 * 28.整数的二进制表示中1的个数
 * 题目：输入一个整数，求该整数的二进制表达中有多少个1。
 * 例如输入10，由于其二进制表示为1010，有两个1，因此输出2。
 */
public class No_28 {
    public static void main(String[] args) {
        //100
        //01100100
        System.out.println(countOne(100)); //3
    }

    public static int countOne(int n) {
        int count = 0;

        while (n != 0) {
            if (n % 2 == 1) {
                ++count;
            }
            n /= 2;
        }
        return count;
    }
}
