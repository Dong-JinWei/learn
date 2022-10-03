/*
 * 插入数组
 * 
 */
package homeworkArrays;

public class Exercise7_4 {

	public static void main(String[] args) {
		int max = 10;
		int[] arr = new int[max];

		int j = creatArrays(arr);//创建数组，并获取下标
		System.out.println("原始数组是：");
		printArrays(arr);
		
		arr[j] = 2;
		System.out.println("插入的数据是：" + arr[j]);
		
		insertArrays(arr, j);
		System.out.println("插入数据后的数组是：");
		printArrays(arr);

	}

	static int creatArrays(int[] arr) {
		int j = 0;
		// 创建数组
		for (int i = 1; i < arr.length; i += 2) {
			arr[j] = i;
			j++;
		}
		return j;// 返回最后一个有效元素的下标
	}

	static void printArrays(int[] arr) {
		for (int num : arr) {
			System.out.print(num + " ");
		}
		System.out.println();
	}

	static void insertArrays(int[] arr, int j) {
		// 插入的数比前一个数小的时候，交换两个数的位置
		for (int i = j; i > 0; i--) {
			if (arr[i] < arr[i - 1]) {
				int temp = arr[i - 1];
				arr[i - 1] = arr[i];
				arr[i] = temp;
			} else {
				break;
			}
		}
	}

}
