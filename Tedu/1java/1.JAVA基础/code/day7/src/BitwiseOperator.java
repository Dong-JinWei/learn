
public class BitwiseOperator {
	public static void main(String[] args) {
		
		System.out.println(4 & 5);
		//  100  4
		//  101  5
		//  100  4		
		System.out.println(4 | 5);
		//  100  4
		//  101  5
		//  101  5
		System.out.println(4 ^ 5);
		//  100  4
		//  101  5
		//  001  1
		
		System.out.println(~42);
		//0010 1010
		//1101 0101 ȷ����һ������
		//1101 0100  ����-1
		//0010 1011  ȡ��  43

	}

}
