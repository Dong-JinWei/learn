package homework;

public class Exercise6_9 {
	public static void main(String[] args) {
		
		double hight = 100; //���ø߶�λ100
		int count = 0; // ͳ�Ƶ�������
		double sum = 100; // ������·�ߣ���Ϊ��ʼ�߶���100�� ������ض�����100�ס�
		while(count < 10) { // ͳ�Ʒ���10�Ρ�
			hight /= 2; // ÿ�θ߶ȳ���2
			sum = sum + hight + hight; //��ÿ�ε�·�߼�����
			count++; //������
		}
		
		System.out.println("�򹲾���"+ sum +"�ס�\n��"+count+"�η����ĸ߶�Ϊ"+ hight +"�ס�");
		
	}

}
