
public class _02Ö½ÅÆÈı½ÇĞÎ {
	

    public static int res = 0;

    public static void f(int[] arr, int n) {

        if (n == arr.length) {
            if (arr[0] + arr[1] + arr[3] + arr[5] == arr[5] + arr[6] + arr[7] + arr[8]
                    && arr[5] + arr[6] + arr[7] + arr[8] == arr[0] + arr[2] + arr[4] + arr[8]) {
                res += 1;
            }
            return;
        }

        for (int i = n; i < arr.length; i++) {
            int temp = arr[n];
            arr[n] = arr[i];
            arr[i] = temp;
            f(arr, n + 1);
            temp = arr[n];
            arr[n] = arr[i];
            arr[i] = temp;
        }

    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        f(arr, 0);
        System.out.println(res);
        System.out.println(res / 6);  
    }
	
}
