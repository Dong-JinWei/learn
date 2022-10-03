package Day3;

public class Day3 {
	public static void main(String[] args) {
//		System.out.println(add(1,2,3));
//		System.out.println(add(1.5,2.5,3.5));
//	}
//	
//	public static int add(int m, int n, int x) {
//		int sum = 0;
//		sum = m + n + x;
//		return sum;
//	}
//	public static double add(double m, double n, double x) {
//		double sum = 0;
//		sum = m + n + x;
//		return sum;

		
		
//		for (int i = 0; i < args.length; i++) {
//			System.out.println("args[" + i + "]: " + args[i]);
//		}
		
		System.out.println(f(5));

	}
	public static int f(int n) {
		
		if (n == 1) {
			return 1;
		}else {
			return n * f(n - 1);
		}
	}

}
