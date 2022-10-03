import java.util.Arrays;
import java.util.Scanner;

public class _06递增三元组 {
	public static void main(String[] args) {
		long ans = 0;
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		int[] c = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			b[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			c[i] = sc.nextInt();
		}

		Arrays.sort(a);
		Arrays.sort(b);
		Arrays.sort(c);

		int p = 0;
		int q = 0;

		for (int i = 0; i < n; i++) {
			while (p < n && a[p] < b[i])
				p++;
			while (p < n && c[q] <= b[i])
				q++;
			ans += 1L * p * (n - q);
		}
		System.out.println(ans);
	}
}
