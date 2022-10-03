package homework;

public class Exercise6_4 {
	public static void main(String[] args) {
		int sum = 1;
		int sum2 = 0;
		int n = 5;
		for (int i = 1; i <= n; i++) {
				sum =sum * i; //计算阶乘
				sum2 = sum2 + sum; // 将阶乘加起来
		}
		System.out.println(n + "的阶乘的和是：" + sum2);
	}

}
