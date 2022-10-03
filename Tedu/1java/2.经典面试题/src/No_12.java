/**
 * @author 26465
 * @create 2022-01-24 17:37
 */
public class No_12 {
    public static void main(String[] args) {
        System.out.println(factorial(5));
    }

    public static int factorial(int n){
        if (n <= 1){
            return 1;
        }
        return factorial(n - 1) + n;
    }
}
