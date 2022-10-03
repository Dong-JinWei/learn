import java.util.ArrayList;
import java.util.List;

/**
 * @author 26465
 * @create 2022-02-08 11:51
 * 第21题
 * 2010年中兴面试题
 * 编程求解：
 * 输入两个整数 n 和 m，从数列1，2，3.......n 中 随意取几个数,
 * 使其和等于 m ,要求将其中所有的可能组合列出来.
 */
public class No_21 {
    public static void main(String[] args) {
        int n = 7;
        int m = 8;
        List<Integer> list = new ArrayList<>();
        printList(n, m, list);
    }

    public static void printList(int m, int n, List<Integer> list) {
        // 如果 n > m， 那么，数列中大于m的部分不可能组成m，所以将n的最大值设置为m
        n = n > m ? m : n;

        // 如果 m<=0 返回这个空的list，
        if (m == 0) {
            System.out.println(list);
            return;
        }

        // n, m 为负数，或n为0 直接退出
        if (n <= 0 || m < 0){
            return;
        }

        List<Integer> list1 = new ArrayList<>(list);
        printList(m, n - 1, list);

        list1.add(n);
        printList(m - n, n - 1, list1);

    }
}
