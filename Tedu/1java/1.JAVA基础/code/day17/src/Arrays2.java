
public class Arrays2 {
	public static void main(String[] args) {
		int[][] arr;
		int[] a = new int[6];

		arr = new int[5][];

		arr[0] = new int[1];
		arr[1] = new int[6];
		arr[2] = new int[8];
		arr[3] = new int[2];
		arr[4] = new int[3];

		for (int[] tempArr : arr) {
			for (int temp : tempArr) {
				System.out.print(temp + " ");
			}
			System.out.println();
		}

		System.out.println();
		arr = new int[][] { { 11, 12 }, { 21, 22 }, { 31, 32 } };

		for (int[] tempArr : arr) {
			for (int temp : tempArr) {
				System.out.print(temp + " ");
			}
			System.out.println();
		}
	}

}
