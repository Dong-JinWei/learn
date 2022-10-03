
public class Combination {
	public static void main(String[] args) {
		int i, j, k;
		int count = 0;

		for (i = 1; i <= 4; i++) {
			for (j = i + 1; j <= 5; j++) {
				for (k = j + 1; k <= 6; k++) {
					System.out.println(i + " " + j + " " + k);
					count++;
				}
			}
		}
		System.out.println("共有" + count + "种组合方式");
	}
}
