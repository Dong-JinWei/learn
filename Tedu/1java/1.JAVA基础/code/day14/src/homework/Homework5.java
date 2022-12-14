/**
 *   
3.求子数组的最大和 
题目： 
输入一个整形数组，数组里有正数也有负数。 
数组中连续的一个或多个整数组成一个子数组，每个子数组都有一个和。 
求所有子数组的和的最大值。要求时间复杂度为O(n)。 
  
例如输入的数组为1, -2, 3, 10, -4, 7, 2, -5，和最大的子数组为3, 10, -4, 7, 2， 
因此输出为该子数组的和18。 

 */

package homework;

public class Homework5 {
	public static void main(String[] args) {

		int[] arr = new int[] { 1, -2, 3, 10, -4, 7, 2, -5 };
		int right, left;
		right = 0;
		left = 1;
		int sum = 0;

		for (int i = 0; i < arr.length; i++) {

			for (int j = right; j < left; j++) {
				sum = sum + arr[j];
			}
			System.out.println(sum);
			left++;
			sum = 0;
		}

	}

}
