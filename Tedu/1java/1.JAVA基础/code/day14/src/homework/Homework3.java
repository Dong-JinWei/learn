/**
 * �Զ������飬�����б��������ȥ����߷ֺ���ͷֵ�ƽ���ɼ���
 */

package homework;

public class Homework3 {
	public static void main(String[] args) {
		int[] scoreArr = new int[] { 10, 6, 7, 8, 8, 7, 9, 8, 8, 7 };

		int max = scoreArr[0];
		int min = scoreArr[0];
		int sum = 0;

		for (int i = 0; i < scoreArr.length; i++) {
			if (scoreArr[i] > max) {
				max = scoreArr[i];
			}
			if (scoreArr[i] < min) {
				min = scoreArr[i];
			}
			sum = sum + scoreArr[i];
		}

		System.out.println("ȥ��һ����߷֣�" + max + "�֣�ȥ��һ����ͷ֣�" + min + "�֡�");
		double avg = (double)(sum - max - min) / (scoreArr.length - 2);
		System.out.println("ƽ�����ǣ�" + avg);

	}

}
