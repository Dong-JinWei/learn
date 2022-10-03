package test;
/*
 * 二分查找
 */

public class BinarySearch2 {
	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };

		int findNum = 6;
		int left = 0;
		int right = arr.length;
		int mid;

		do {
			mid = (left + right) / 2;
			
			if (findNum == arr[mid]) {
				System.out.println("已找到，" + arr[mid] + "的下标是" + mid);
				break;
			}else if (findNum > arr[mid]) {
				left = mid + 1;
			} else if (findNum < arr[mid]) {
				right = mid - 1;
			}
		} while (left <= right);

		
		System.out.println("结束");

	}

}
