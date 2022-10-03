/*
 * 
 * 自定义数组，对数组元素进行初始化，打印出第二大的值。
 */

package homework;

public class Homework2 {
	public static void main(String[] args) {
		int[] arr = new int[] { 4, 6, 9, 0, -1, 8 };
		int max1 = arr[0]; // 存放第一大的值
		int max2 = arr[0]; // 存放第二大的值

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max2) {
				max2 = arr[i]; // 如果这个数比第二大的数大，那么就把他保存到max2里
			}
			if (max2 > max1) { // 如果第二大的数比第一大的数还大，那么就交换位置
				int temp = max1;
				max1 = max2;
				max2 = temp;
			}
		}

		System.out.println("第二大的值是：" + max2);
	}

}
