/**
 * 5.6����-�ٷ��Ƴɼ�,Ҫ������ɼ��ȼ�'A'��'B��'C'��'D'��'E'��90������Ϊ'A'��80��89��Ϊ'B',70��79��Ϊ'C',60��69��Ϊ'D',60������Ϊ'E'��
 * 
 * 
 * @author 26465
 *
 */
public class Homework5_6 {
	public static void main(String[] args) {
		int score = 80;

		if (score >= 90) {
			System.out.println('A');
		} else if (score >= 80 && score < 90) {
			System.out.println('B');
		} else if (score >= 70 && score < 80) {
			System.out.println('C');
		} else if (score >= 60 && score < 70) {
			System.out.println('D');
		} else
			System.out.println('E');
	}

}
