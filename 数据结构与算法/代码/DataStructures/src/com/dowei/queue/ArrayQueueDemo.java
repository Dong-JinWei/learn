package com.dowei.queue;

import java.util.Scanner;

public class ArrayQueueDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ����һ������
		ArrayQueue arrayQueue = new ArrayQueue(3);
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
class ArrayQueue {
	private int maxSize;//��ʾ�����������
	private int front;//����ͷ
	private int rear;//����β
	private int[] arr;//������ݣ�ģ�����

	// ��ʼ������
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

	// ������������
	public void addQueue(int n) {
		if (isFull()) {
			System.out.println("�������������ܼ������ݡ�����");
			return;
		}
		rear++;
		arr[rear] = n;
	}

	// ��ȡ��������
	public int getQueue() {
		if (isEmpty()) {
			throw new RuntimeException("���пգ�����ȡ����");
		}
		front++;
		return arr[front];
	}

	// ��ʾ����˵������
	public void showQueue() {
		if (isEmpty()) {
			System.out.println("���пգ�û������");
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("arr[%d]=%d\n", i, arr[i]);
		}
	}

	// ��ʾ���е�ͷ���ݣ�ע�ⲻ��ȡ����
	public int headQueue() {
		if (isEmpty()) {
			throw new RuntimeException("���пգ�û������");
		}
		return arr[front + 1];
	}
}
