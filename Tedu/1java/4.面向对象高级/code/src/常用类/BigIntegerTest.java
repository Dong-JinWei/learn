package 常用类;

import java.math.BigInteger;

/**
 * @author 26465
 * @create 2022-01-26 11:16
 */
public class BigIntegerTest {
    static String factorial(int n) {
        BigInteger result = new BigInteger("1");
        for (int i = 1; i <= n; i++) {
            result = result.multiply(new BigInteger(i + ""));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));
        System.out.println(factorial(10));
        System.out.println(factorial(20));

        BigInteger big = new BigInteger("123456789");
        big = big.add(new BigInteger("987654321"));
        System.out.println(big.toString());

    }
}
