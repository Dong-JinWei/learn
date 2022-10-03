package homework;

public class Exercise6_10 {

	public static void main(String[] args) {
		int peach = 1;
		for (int i = 0; i < 9; i++) { // 计算第一天的桃子，所以往回推9天
			// 正算的话是 peach / 2 - 1；所以倒着往回推就是 (peach + 1) * 2
			peach = (peach + 1) * 2; 
		}
//		System.out.println("树上共有"+ peach+"个桃子");
//		peach = peach / 2 - 1;  //本来打算计算树上共有的桃子数
//		 然后根据桃子数计算第一天摘了的，后来发现回推9天和这个计算结果是一样的。
		System.out.println("第一天摘了" + peach + "个桃子");

	}

}
