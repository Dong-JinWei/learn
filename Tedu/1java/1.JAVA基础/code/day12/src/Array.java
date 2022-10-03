
public class Array {
	public static void main(String[] args) {
		int i, j, k;
		int count = 0;

		for (i = 1; i <= 6; i++) {
			for (j = 1; j <= 6; j++) {
				if (i != j) {
					for (k = 1; k <= 6; k++) {
						if (i != k & j != k) {
							System.out.println(i + " " + j + " " + k);
							count++;
						}
					}
				}
			}
		}
		System.out.println("共有" + count + "种结果");
	}

}
