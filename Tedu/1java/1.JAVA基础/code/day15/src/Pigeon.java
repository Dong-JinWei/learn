
public class Pigeon {
	public static void main(String[] args) {
		int[] arr = { 5, 1, 9, 7, 8, 6, 4, 2 };

		int max = arr[0];

		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}

		System.out.println(max);
		int[] arr2 = new int[max + 1];

		for (int i = 0; i < arr.length; i++) {
			arr2[arr[i]] = 1;
		}

		for (int i = 0; i < arr2.length; i++) {
			if (arr2[i] == 1) {
				System.out.print(i + " ");

			}
		}

	}

}
