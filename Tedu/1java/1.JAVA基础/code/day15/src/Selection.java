
public class Selection {
	public static void main(String[] args) {
		int[] arr = { 97, 42, 1, 620, 7, 74, 0, 41, 104, 106, 224 };
		
		System.out.println("原数组为：");
		for (int num : arr) {
			System.out.print(num + " ");
		}
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			int min = i;
			for (int j = i; j < arr.length; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			
			if (i != min) {
				int temp = arr[i];
				arr[i] = arr[min];
				arr[min] = temp;
			}
		}
		
		System.out.println("选择排序后的数组为：");
		for (int num : arr) {
			System.out.print(num + " ");
		}
		
	}

}
