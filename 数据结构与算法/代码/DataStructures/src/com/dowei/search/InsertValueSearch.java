package com.dowei.search;

public class InsertValueSearch {
	public static void main(String[] args) {
//		int [] arr = new int[100];
//		for(int i = 0; i < 100; i++) {
//			arr[i] = i + 1;
//		}
		
		int arr[] = { 1, 8, 10, 89,1000,1000, 1234 };
		
		int index = insertValueSearch(arr, 0, arr.length - 1, 1234);
		//int index = binarySearch(arr, 0, arr.length, 1);
		System.out.println("index = " + index);
		
		//System.out.println(Arrays.toString(arr));
	}
	
	public static int insertValueSearch(int[] arr, int left, int right, int findVal) {
		System.out.println("插值查找的次数");
		if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) {
			return -1;
		}
		
		int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
		int midVal = arr[mid];
		if (findVal > midVal) {
			return insertValueSearch(arr, mid + 1, right, findVal);
		}else if (findVal < midVal) {
			return insertValueSearch(arr, left, mid - 1, findVal);
		}else {
			return mid;
		}
	}
	
	public static int binarySearch(int[] arr, int left, int right, int findVal) {
		System.out.println("二分查找被调用~");
		// 当 left > right 时，说明递归整个数组，但是没有找到
		if (left > right) {
			return -1;
		}
		int mid = (left + right) / 2;
		int midVal = arr[mid];

		if (findVal > midVal) { // 向 右递归
			return binarySearch(arr, mid + 1, right, findVal);
		} else if (findVal < midVal) { // 向左递归
			return binarySearch(arr, left, mid - 1, findVal);
		} else {

			return mid;
		}

	}

}
