package homework;

public class Exercise6_7 {
	public static void main(String[] args) {
		int sum = 0;
		String str = "";
		for (int i = 1; i <= 1000; i++) { // 循环1000次
			for (int j = 1; j < i; j++) { // 所有小于i的数。

				if (i % j == 0) { // 如果求余==0，说明j就是i的因子
					if (j != 1) {
						str = str + "," + j;
					}
					
					sum = sum + j; // 将所有因子加起来
				}

			}

			if (sum == i) {
				System.out.printf("%d its factors are 1%s\n",i ,str);
			}
			str = ""; //清空字符串
			sum = 0; // 内层循环结束后，重置sum为0
			
//			if (sum == i) { // 如果所有因子的和等于 i
//			System.out.printf("%d its factors are ",i); // 按格式输出
//			System.out.print(1); //1是所有数字的因子，所以直接输出
//			for (int j = 2; j < sum; j++) { //j从2开始，找sum的因子
//				if (sum % j == 0) { //判断是不是因子
//					System.out.print("," + j); //如果是就输出这个因子
//				}
//			}
//			System.out.println();
//		}

		}

	}
}
