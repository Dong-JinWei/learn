
public class _03ÕñĞËÖĞ»ª {
	public static void main(String[] args) {
		int ans = f(0, 0);
		System.out.println(ans);
	}

	private static int f(int i, int j) {
		// TODO Auto-generated method stub
		if (i == 3 || j == 4)
			return 1;
		return f(i + 1, j) + f(i, j + 1);
	}

}
