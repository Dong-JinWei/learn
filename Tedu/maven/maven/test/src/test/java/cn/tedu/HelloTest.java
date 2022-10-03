package cn.tedu;

import org.junit.Test;

public class HelloTest {
	@Test
	public void test01(){
		Hello hello = new Hello();
		String s = hello.f("你好");
		System.out.println(s);
	}
}
