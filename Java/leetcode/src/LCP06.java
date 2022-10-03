import java.util.function.DoubleToIntFunction;

import javax.rmi.CORBA.Stub;

public class LCP06 {
    public static int minCount(int[] coins) {
        int count = 0;
        for (int n : coins) {
            double min = Math.ceil((double) n / 2);
            count += min;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] coins = { 4, 2, 1 };
        int n = minCount(coins);
        System.out.println(n);
    }
}
