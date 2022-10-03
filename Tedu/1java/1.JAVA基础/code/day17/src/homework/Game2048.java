package homework;

public class Game2048 {
	public static void main(String[] args) {
		int[][] arr = { { 0, 2, 2, 4 },
						{ 0, 4, 2, 0 },
						{ 0, 0, 2, 0 },
						{ 0, 2, 0, 8 } };

		int flag = 0;
		int first = 0;

		System.out.println("原数组为：");
		for (int[] num1 : arr) {
			for (int num2 : num1)
				System.out.print(num2 + " ");
			System.out.println();
		}
		System.out.println();
		for (int j = 0; j < arr.length; j++) {
			for (int i = 0; i < arr[j].length; i++) {
				if (arr[j][i] != 0) {
					if (flag == 0) {
						first = i;
						flag = 1;
					} else {
						if (arr[j][first] == arr[j][i]) {
							arr[j][first] += arr[j][i];
							arr[j][i] = 0;
							flag = 0;
						} else {
							first = i;
							flag = 1;
						}
					}
				}
			}
			flag = 0;
		}

		System.out.println("合并后为：");
		for (int[] num1 : arr) {
			for (int num2 : num1)
				System.out.print(num2 + " ");
			System.out.println();
		}
		System.out.println();
		int i = 0;
		int j = 0;
		for (int m = 0; m < arr.length; m++) {
			for (i = 0; i < arr[m].length; i++) {
				if (arr[m][i] != 0) {
					arr[m][j] = arr[m][i];
					arr[m][i] = 0;
					j++;
				}
			}
			j = 0;
		}

		System.out.println("排序后：");
		for (int[] num1 : arr) {
			for (int num2 : num1)
				System.out.print(num2 + " ");
			System.out.println();
		}
		System.out.println();
	}

}
