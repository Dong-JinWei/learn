package homework;

public class Exercise6_7 {
	public static void main(String[] args) {
		int sum = 0;
		String str = "";
		for (int i = 1; i <= 1000; i++) { // ѭ��1000��
			for (int j = 1; j < i; j++) { // ����С��i������

				if (i % j == 0) { // �������==0��˵��j����i������
					if (j != 1) {
						str = str + "," + j;
					}
					
					sum = sum + j; // ���������Ӽ�����
				}

			}

			if (sum == i) {
				System.out.printf("%d its factors are 1%s\n",i ,str);
			}
			str = ""; //����ַ���
			sum = 0; // �ڲ�ѭ������������sumΪ0
			
//			if (sum == i) { // ����������ӵĺ͵��� i
//			System.out.printf("%d its factors are ",i); // ����ʽ���
//			System.out.print(1); //1���������ֵ����ӣ�����ֱ�����
//			for (int j = 2; j < sum; j++) { //j��2��ʼ����sum������
//				if (sum % j == 0) { //�ж��ǲ�������
//					System.out.print("," + j); //����Ǿ�����������
//				}
//			}
//			System.out.println();
//		}

		}

	}
}
