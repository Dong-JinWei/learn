package homework;

public class Exercise6_9 {
	public static void main(String[] args) {
		
		double hight = 100; //设置高度位100
		int count = 0; // 统计弹跳次数
		double sum = 100; // 经过的路线，因为初始高度是100， 多以球必定经过100米。
		while(count < 10) { // 统计反弹10次。
			hight /= 2; // 每次高度除以2
			sum = sum + hight + hight; //将每次的路线加起来
			count++; //计数器
		}
		
		System.out.println("球共经过"+ sum +"米。\n第"+count+"次反弹的高度为"+ hight +"米。");
		
	}

}
