import java.math.BigDecimal;
import java.math.BigInteger;

public class _04黄金连分数 {
	public static void main(String[] args) {
		BigInteger a = BigInteger.ONE;
		BigInteger b = BigInteger.ONE;
		for (int i = 3; i < 500; i++) {
			BigInteger t = b;
			b = a.add(b);
			a = t;
		}
		BigDecimal divide = new BigDecimal(a,110).divide(new BigDecimal(b,110),BigDecimal.ROUND_HALF_DOWN);
		System.out.println(divide.toPlainString().substring(0,103));
		
		//0.6180339887498948482045868343656381177203091798057628621354486227052604628189024497072072041893911375
	}

}
