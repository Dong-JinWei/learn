package homeworkMethods;

public class Exercise8_10 {
	public static void main(String[] args) {
		String str = "name isisis dowei";
		word(str);
	}
	

	static void word(String str) {
		char[] chars = str.toCharArray();
		
		int maxBegin = 0,maxEnd = 0, max = 0;
		int begin, end, value;
		int i;
		
		for (i = 0, value = 0, begin = 0; i < chars.length; i++) {
			end = i;
			value++;
			
			if(value > max) {
				maxBegin = begin;
				maxEnd = end;
				max = value;
			}
			
			if (chars[end] == ' ') {
				begin = i + 1;
				value = 0;
			}
			
		}
		
		System.out.println("最长单词的起始下标是：" + maxBegin + "，最长单词的结束下标是" + maxEnd);
		for (int k = maxBegin; k <= maxEnd; k++) {
			System.out.print(chars[k]);
		}
	}
}
