/**
 * 5.6给出-百分制成绩,要求输出成绩等级'A'、'B、'C'、'D'、'E'。90分以上为'A'，80～89分为'B',70～79分为'C',60～69分为'D',60分以下为'E'。
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
