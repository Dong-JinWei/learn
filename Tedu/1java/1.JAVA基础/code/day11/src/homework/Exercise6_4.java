package homework;

public class Exercise6_4 {
	public static void main(String[] args) {
		int sum = 1;
		int sum2 = 0;
		int n = 5;
		for (int i = 1; i <= n; i++) {
				sum =sum * i; //����׳�
				sum2 = sum2 + sum; // ���׳˼�����
		}
		System.out.println(n + "�Ľ׳˵ĺ��ǣ�" + sum2);
	}

}
