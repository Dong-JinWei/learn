package com.dowei.queue;

import java.util.Scanner;

public class ArrayQueueDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 创建一个队列
		ArrayQueue arrayQueue = new ArrayQueue(3);
		char key = ' ';
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
		while (loop) {
			System.out.println("s(show): 显示队列");
			System.out.println("e(exit): 退出程序");
			System.out.println("a(add): 添加数据到队列");
			System.out.println("g(get): 从队列取数据");
			System.out.println("h(head): 查看队列头的数据\n");
			key = scanner.next().charAt(0);
			switch (key) {
			case 's':
				arrayQueue.showQueue();
				break;
			case 'a':// 插入数据
				System.out.println("请输入一个数");
				int value = scanner.nextInt();
				arrayQueue.addQueue(value);
				break;
			case 'g':// 取出数据
				try {
					int res = arrayQueue.getQueue();
					System.out.printf("取出的数据是%d\n", res);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'h':// 查看队列头数据
				try {
					int res = arrayQueue.headQueue();
					System.out.printf("队列头数据是%d\n", res);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'e':
				scanner.close();
				loop = false;
				break;
			default:
				break;
			}
		}
		System.out.println("程序退出！");
	}

}

//
class ArrayQueue {
	private int maxSize;//表示数组最大容量
	private int front;//队列头
	private int rear;//队列尾
	private int[] arr;//存放数据，模拟队列

	// 初始化队列
	public ArrayQueue(int arrMaxSize) {
		maxSize = arrMaxSize;
		arr = new int[maxSize];
		front = -1;
		rear = -1;
	}

	public boolean isFull() {
		return rear == maxSize - 1;
	}

	public boolean isEmpty() {
		return rear == front;
	}

	// 向队列添加数据
	public void addQueue(int n) {
		if (isFull()) {
			System.out.println("队列已满，不能加入数据···");
			return;
		}
		rear++;
		arr[rear] = n;
	}

	// 获取队列数据
	public int getQueue() {
		if (isEmpty()) {
			throw new RuntimeException("队列空，不能取数据");
		}
		front++;
		return arr[front];
	}

	// 显示队列说有数据
	public void showQueue() {
		if (isEmpty()) {
			System.out.println("队列空，没有数据");
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("arr[%d]=%d\n", i, arr[i]);
		}
	}

	// 显示队列的头数据，注意不是取数据
	public int headQueue() {
		if (isEmpty()) {
			throw new RuntimeException("队列空，没有数据");
		}
		return arr[front + 1];
	}
}
