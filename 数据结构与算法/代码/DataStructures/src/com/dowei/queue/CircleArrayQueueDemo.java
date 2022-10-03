package com.dowei.queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ����һ������
		CircleArrayQueue arrayQueue = new CircleArrayQueue(4);
		char key = ' ';
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
		while (loop) {
			System.out.println("s(show): ��ʾ����");
			System.out.println("e(exit): �˳�����");
			System.out.println("a(add): ������ݵ�����");
			System.out.println("g(get): �Ӷ���ȡ����");
			System.out.println("h(head): �鿴����ͷ������\n");
			key = scanner.next().charAt(0);
			switch (key) {
			case 's':
				arrayQueue.showQueue();
				break;
			case 'a':// ��������
				System.out.println("������һ����");
				int value = scanner.nextInt();
				arrayQueue.addQueue(value);
				break;
			case 'g':// ȡ������
				try {
					int res = arrayQueue.getQueue();
					System.out.printf("ȡ����������%d\n", res);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'h':// �鿴����ͷ����
				try {
					int res = arrayQueue.headQueue();
					System.out.printf("����ͷ������%d\n", res);
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
		System.out.println("�����˳���");
	}
}

//
class CircleArrayQueue {
	private int maxSize;// ��ʾ�����������
	private int front;// ����ͷ
	private int rear;// ����β
	private int[] arr;// ������ݣ�ģ�����

	// ��ʼ������
	public CircleArrayQueue(int arrMaxSize) {
		maxSize = arrMaxSize;
		arr = new int[maxSize];
		front = 0;
		rear = 0;
	}

	public boolean isFull() {
		return (rear + 1) % maxSize == front;
	}

	public boolean isEmpty() {
		return rear == front;
	}

	// ������������
	public void addQueue(int n) {
		if (isFull()) {
			System.out.println("�������������ܼ������ݡ�����");
			return;
		}
		arr[rear] = n;
		rear = (rear + 1) % maxSize;

	}

	// ��ȡ��������
	public int getQueue() {
		if (isEmpty()) {
			throw new RuntimeException("���пգ�����ȡ����");
		}
		
		//������Ҫ������front��ָ����еĵ�һ��Ԫ�� 
		//1. �Ȱ�front���浽��ʱ������ 
		//2. ��front����
		//3. ����ʱ��������
		int value = arr[front];
		front = (front + 1) % maxSize;
		return value;
	}

	// ��ʾ����˵������
	public void showQueue() {
		if (isEmpty()) {
			System.out.println("���пգ�û������");
			return;
		}
		for (int i = front; i < front + size(); i++) {
			System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
		}
	}

	public int size() {
		return (rear + maxSize - front) % maxSize;
	}

	// ��ʾ���е�ͷ���ݣ�ע�ⲻ��ȡ����
	public int headQueue() {
		if (isEmpty()) {
			throw new RuntimeException("���пգ�û������");
		}
		return arr[front];
	}
}