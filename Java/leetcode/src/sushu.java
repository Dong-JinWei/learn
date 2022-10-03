public class sushu {
    public static void main(String[] args) {
        int n = 100;
//        int suShuCount = suShuCount(n);
//
//        System.out.println(suShuCount);

        System.out.println(eratosthenes(n));
    }

    public static int suShuCount(int n){
        int count = 0;
        for(int i = 2; i < n; i++){
            count += isPrime(i) ? 1 : 0;
        }
        return count;
    }

    public static boolean isPrime(int x){
        for (int i = 2; i * i <= x; i++){
            if (x % i == 0){
                return false;
            }
        }
        System.out.println(x);
        return true;
    }

    public static int eratosthenes(int n){
        boolean[] isPrime = new boolean[n];
        int count = 0;
        for(int i = 2; i < n; i++){
            if (!isPrime[i]){
                count++;
                for(int j = i * i; j < n; j += i){
                    isPrime[j] = true;
                }
            }
        }
        return count;
    }
}
