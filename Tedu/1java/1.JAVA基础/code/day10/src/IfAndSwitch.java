
public class IfAndSwitch {
	public static void main(String[] args) {
		int score = 80;

		if (score >= 60) {
			System.out.println("及格");
		} else {
			System.out.println("不及格");
		}

		// if语句只与后边的语句结合
		if (score > 60) // 与下边的if语句结合
			if (score >= 80) // 因为这是一个语句体，所以，他会执行整个if-else，而不是只执行if。
				System.out.println("优秀");
			else
				System.out.println("良好");
		else
			System.out.println("不及格");

		// 不建议以上的书写，可以写成如下所示
		if (score > 60) { // 写成这样更有利于阅读和后期维护
			if (score >= 80) {
				System.out.println("优秀");
			} else {
				System.out.println("良好");
			}
		} else {
			System.out.println("不及格");
		}
		

	}

}
