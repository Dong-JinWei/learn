package homework;

public class Exercise6_6 {
	public static void main(String[] args) {
		
		for (int i = 100; i <= 999; i++) { //��Ϊ����λ���������Ǵ�100��ʼ����999����
			int b = i / 100;  // ȡ��λ����
			int s = i /10 % 10; // ȡʮλ����
			int g = i % 10; // ȡ��λ����
			
			if (i == (b * b * b + s * s * s + g * g * g)) { 
				//����������λ�����η�����i����ô����������
				System.out.println(i);
			}
		}
	}

}
