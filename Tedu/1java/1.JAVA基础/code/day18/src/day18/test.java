package day18;

public class test {
	static void swap(int[] arr01,int[] arr02) {
		int[] t;
		t = arr01; arr01 = arr02; arr02 = t;
	}
	
	public static void main(String[] args) {
		int[] a = {1};
		int[] b = {2};
		swap(a, b);
		System.out.println(a[0] + " " + b[0]);
	}

}
