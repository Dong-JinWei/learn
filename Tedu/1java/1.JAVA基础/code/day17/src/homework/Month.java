package homework;

public class Month {
	public static void main(String[] args) {
		int[][] month = new int[][] {
            {31, 28, 31, 30, 31, 30, 31, 31, 30},
            {31, 29, 31, 30, 31, 30, 31, 31, 30}
		};
		
		int year = 2000, begin = 2, end = 4;
		int index, count = 0;
		
		if (year % 4 == 0 && year != 100 || year % 400 == 0)
			index = 1;
		else
			index = 0;
		
		for (int i = begin; i <= end; i++) {
			count += month[index][i - 1];
		}
		
		System.out.println(count);
	}

}
