
public class Pigeon2 {
	public static void main(String[] args) {
		int[] arr = { 5, 1, 9, 9, 9, 9, 7, 8, 8, 8, 6, 4, 2 };

		int max = arr[0];
		
		System.out.println("原数组为：");
		for (int num : arr) {
			System.out.print(num + " ");
		}
		System.out.println();
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}

		int[] arr2 = new int[max + 1];

		for (int i = 0; i < arr.length; i++) {
			arr2[arr[i]]++;
		}

		System.out.println("鸽巢排序后为：");
		for (int i = 0; i < arr2.length; i++) {
			if (arr2[i] > 0) {
				for (int j = 0; j < arr2[i]; j++) {
					System.out.print(i + " ");
				}
			}
		}

	}

}
