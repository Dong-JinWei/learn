package homework;

public class Exercise6_6 {
	public static void main(String[] args) {
		
		for (int i = 100; i <= 999; i++) { //因为是三位数，所以是从100开始，到999结束
			int b = i / 100;  // 取百位数字
			int s = i /10 % 10; // 取十位数字
			int g = i % 10; // 取个位数字
			
			if (i == (b * b * b + s * s * s + g * g * g)) { 
				//如果满足各个位的三次方等于i，那么就输出这个数
				System.out.println(i);
			}
		}
	}

}
