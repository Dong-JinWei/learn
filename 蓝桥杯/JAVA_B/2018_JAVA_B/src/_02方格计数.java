
public class _02方格计数 {
	public static void main(String[] args) {
		int d = 1000, ans = 0;
		for (int i = 1; i <= d; i++)
			for (int j = 1; j <= d; j++)
				if (i * i + j * j <= d * d)
					ans++;
		System.out.println(ans * 4);
	}
}
