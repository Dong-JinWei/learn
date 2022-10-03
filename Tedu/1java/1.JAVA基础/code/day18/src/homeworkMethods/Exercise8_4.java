package homeworkMethods;

public class Exercise8_4 {
	public static void main(String[] args) {
		int[][] arr = new int[][] { { 1, 2, 3 }, { 1, 2, 3 }, { 1, 2, 3 } };

		System.out.println("原数组为：");
		printArrays(arr);
		arr = transpose(arr);
		System.out.println("转置后的数组是：");
		printArrays(arr);
	}

	static int[][] transpose(int[][] arr) {
		int[][] arrTemp = new int[3][3];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0, k = 0; j < arr[0].length; j++, k++) {
				arrTemp[k][i] = arr[i][j];
			}
		}
		return arrTemp;
	}

	static void printArrays(int[][] arr) {
		for (int[] n : arr) {
			for (int m : n) {
				System.out.print(m + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
