package day18;

public class ตÝน้ {
	public static void main(String[] args) {
		System.out.println(f(5));
	}
	
	static int f(int n) {
		
		if (n == 1) {
			return 1;
		}else {
			return n*f(n-1);
		}
	}

}
