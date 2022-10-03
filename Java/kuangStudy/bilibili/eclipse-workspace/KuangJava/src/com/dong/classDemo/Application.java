package com.dong.classDemo;

public class Application{
	public static void main(String[] atgs) {
		
		//类: 抽象的,实例化
		
		Persion xm = new Persion();
		Persion xh = new Persion();
		
		xm.name = "小明";
		xm.age = 3;
		
		System.out.println(xm.name);
		System.out.println(xm.age);
		
		xh.name = "小红";
		xh.age = 3;
		
		System.out.println(xh.name);
		System.out.println(xh.age);
		
		
	}

}
