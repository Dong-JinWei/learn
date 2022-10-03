package homeworkArrays;

public class Exercise7_8 {
	public static void main(String[] args) {
		int[][] arr = new int[][] { { 1, 3, 2 }, { 1, 5, 2 }, { 1, 6, 2 } };

		printArrays(arr);
		saddlePoint(arr);
	}

	//先找出每一行最大的数字，然后看这个数字是不是他所对应列的最小的一个数组。
	static void saddlePoint(int[][] arr) {
		
		int minIndex = 0;
		int maxIndex = 0;
		for (int i = 0; i < arr.length; i++) {
			maxIndex = 0;
			minIndex = 0;

			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] > arr[i][maxIndex]) {
					maxIndex = j;// 循环遍历每一行，找出这一行的最大值
					for (int k = 0; k < arr.length; k++) {
						// 遍历最大值的这一列，判断他是不时最小的
						if (arr[i][maxIndex] > arr[k][maxIndex]) {
							// 比着一列的的任何一个数字大，就break
							break;
						} else {
							// 否则输出这个坐标
							minIndex = i;
							System.out.println("(" + minIndex + ", " + maxIndex + ")");
							break;
						}
					}
				}
			}

		}
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
