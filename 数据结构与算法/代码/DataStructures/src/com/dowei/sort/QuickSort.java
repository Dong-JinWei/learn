package com.dowei.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class QuickSort {
	public static void main(String[] args) {
		//int[] arr = {-9,78,0,23,-567,70, -1,900, 4561};
		
		//测试快排的执行速度
		// 创建要给80000个的随机的数组
		int[] arr = new int[8000000];
		for (int i = 0; i < 8000000; i++) {
			arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
		}
		
		System.out.println("排序前");
		Date data1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1Str = simpleDateFormat.format(data1);
		System.out.println("排序前的时间是=" + date1Str);
		
		quickSort(arr, 0, arr.length-1);
		
		Date data2 = new Date();
		String date2Str = simpleDateFormat.format(data2);
		System.out.println("排序前的时间是=" + date2Str);
		//System.out.println("arr=" + Arrays.toString(arr));
	}
	
	public static void quickSort(int[] arr, int left, int right) {
		int l = left;
		int r = right;
		
		int pivot = arr[(left + right) / 2];
		int temp = 0;
		
		while(l < r) {
			while (arr[l] < pivot) {
				l += 1;
			}
			while (arr[r] > pivot) {
				r -= 1;
			}
			
			if (l >= r) {
				break;
			}
			
			temp = arr[l];
			arr[l] = arr[r];
			arr[r] = temp;
			
			if (arr[l] == pivot) {
				r -= 1;
			}
			if (arr[r] == pivot) {
				l += 1;
			}
		}
		if (l == r) {
			l += 1;
			r -= 1;
		}
		if (left < r) {
			quickSort(arr, left, r);
			quickSort(arr, l, right);
		}
	}

}
