package com.dowei.binarysearchnorecursion;

public class BinarySearchNoRecur {
	public static void main(String[] args) {
		int[] arr = {1,3, 8, 10, 11, 67, 100};
		System.out.println(binarySearch(arr, 10));
	}
	
	public static int binarySearch(int[] arr, int target) {
		int left = 0;
		int right = arr.length - 1;
		while(left <= right) {
			int mid = (right + left) / 2;
			if(arr[mid] == target) {
				return mid;
			}else if(target > arr[mid]) {
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
		return -1;
	}
}
