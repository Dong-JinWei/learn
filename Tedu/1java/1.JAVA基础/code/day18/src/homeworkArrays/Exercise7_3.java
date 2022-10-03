/*
 * 矩阵对角线的和
 */

package homeworkArrays;

public class Exercise7_3 {
	public static void main(String[] args) {
		int[][] arr = new int[][] { { 1, 2, 3 }, { 3, 2, 1 }, { 1, 3, 2 } };
		
		System.out.println("右对角线的和为：" + diagonalRight(arr));
		System.out.println("做对角线的和为：" + diagonalLeft(arr));
	}

	static int diagonalRight(int[][] arr) {
		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i][i];// 对角线（0，0），（1，1），（2，2）
		}
		return sum;
	}

	static int diagonalLeft(int[][] arr) {
		int sum = 0;
		for (int i = 0, j = arr.length - 1; i < arr.length; i++, j--) {
			sum += arr[i][j];// 对角线（0，2），（1，1），（2，1）
		}
		return sum;
	}
}
