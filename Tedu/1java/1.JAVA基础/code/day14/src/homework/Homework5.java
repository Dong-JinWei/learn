/**
 *   
3.������������� 
��Ŀ�� 
����һ���������飬������������Ҳ�и����� 
������������һ�������������һ�������飬ÿ�������鶼��һ���͡� 
������������ĺ͵����ֵ��Ҫ��ʱ�临�Ӷ�ΪO(n)�� 
  
�������������Ϊ1, -2, 3, 10, -4, 7, 2, -5��������������Ϊ3, 10, -4, 7, 2�� 
������Ϊ��������ĺ�18�� 

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
