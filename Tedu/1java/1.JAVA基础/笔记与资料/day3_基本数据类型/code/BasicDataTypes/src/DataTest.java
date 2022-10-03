
public class DataTest {
	public static void main(String[] args) {
		
		System.out.println("byte的最大值："+Byte.MAX_VALUE);
		System.out.println("int的最大值："+Integer.MAX_VALUE);
		System.out.println("Long的最大值："+Long.MAX_VALUE);
		System.out.println();
		
		//计算一年有多少毫秒
		System.out.println("365*24*60*60*1000 = "+(365*24*60*60*1000));//数据超过int的最大范围
		System.out.println("365L*24L*60L*60L*1000L = "+ (365L*24L*60L*60L*1000L));
		System.out.println();
		
		//浮点数的精度
		float f1 = 12.3f;
		float f2 = 12.4f;
		float f3 = f2 - f1;
		System.out.println("12.4f-12.3f 是否等于 0.1f：" + (f3 == 0.1f));
		System.out.println();
		
		//进制的转换
		System.out.println("0b10转换为十进制是：" + 0b10); //2
		System.out.println("010转换为十进制是：" + 010); //8
		System.out.println("10转换为十进制是：" + 10); //10
		System.out.println("0x10转换为十进制是：" + 0x10); //16
		System.out.println();
		
	}

}
