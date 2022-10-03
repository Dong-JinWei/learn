package homework;

public class Matrix {
	public static void main(String[] args) {
		int[][] arr1 = new int[][] { { 1, 2, 3, 4 }, { 2, 3, 4, 5 } };

		int[][] arr2 = new int[][] { { 1, 2 }, { 4, 4 }, { 5, 6 }, { 6, 8 } };

		int line = arr1.length;
		int column = arr2[0].length;
		int[][] arr3 = new int[line][column];

		if (line != column) {
			System.out.println("这两个矩阵不可以相乘");
			return;
		}

		for (int i = 0; i < line; i++) {
			for (int j = 0; j < line; j++) {
				for (int k = 0; k < arr2.length; k++) {
					arr3[i][j] += arr1[i][k] * arr2[k][j];
				}
			}
		}
		System.out.println("第一个矩阵为：");
		for (int[] num1 : arr1) {
			for (int num2 : num1)
				System.out.print(num2 + "  ");
			System.out.println();
		}
		System.out.println();
		
		System.out.println("第二个矩阵为：");
		for (int[] num1 : arr2) {
			for (int num2 : num1)
				System.out.print(num2 + "  ");
			System.out.println();
		}
		System.out.println();
		
		System.out.println("相乘后矩阵为：");
		for (int[] num1 : arr3) {
			for (int num2 : num1)
				System.out.print(num2 + "  ");
			System.out.println();
		}

	}

}
