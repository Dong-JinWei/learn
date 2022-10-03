/**
 * 选择法对十个整数排序
 */
package homeworkArrays;

public class Exercise7_2 {
	public static void main(String[] args) {
		int[] arr = new int[] { 0, 1, 3, 4, 5, 7, 8, 9, 2, 6 };

		System.out.println("排序前");
		printArr(arr);
	
		selectionSort(arr);
		System.out.println("排序后");
		printArr(arr);
		
		
	}
	static void printArr(int[] arr) {
		for (int n : arr) {
			System.out.print(n + " ");
		}
		System.out.println();
	}

	static void selectionSort(int[] arr) {
		int min = 0;

		for (int i = 0; i < arr.length; i++) {
			min = i;// 假设i为最小值
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[min])// 如果当前值小于最小值，就将当前值设置为min。
					min = j;
			}

			if (i != min) {// 如果值发生过变动，就将两个值的位置交换
				int temp = arr[i];
				arr[i] = arr[min];
				arr[min] = temp;
			}
		}
	}

}
