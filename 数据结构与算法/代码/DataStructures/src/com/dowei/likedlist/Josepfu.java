package com.dowei.likedlist;

public class Josepfu {

	public static void main(String[] args) {
		// ����
		CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
		circleSingleLinkedList.addBoy(5); // ����5��С��
		circleSingleLinkedList.showBoy();
		
		//����С����Ȧ�Ƿ���ȷ
		circleSingleLinkedList.countBoy(1, 2, 5);

	}

}

//����һ�����εĵ�������
class CircleSingleLinkedList {
	// ����һ�� first �ڵ�
	private Boy first = new Boy(-1);

	// ���С��������һ����������
	public void addBoy(int nums) {
		// nums ��һ������У��
		if (nums < 1) {
			System.out.println("nums��ֵ����ȷ");
			return;
		}
		Boy curBoy = null;// ����ָ��
		// ʹ��for���������ǵĻ�������
		for (int i = 1; i <= nums; i++) {
			Boy boy = new Boy(i);
			// ����ǵ�һ��С��
			if (i == 1) {
				first = boy;
				first.setNext(first);// ���ɻ�
				curBoy = first;
			} else {
				curBoy.setNext(boy);
				boy.setNext(first);
				curBoy = boy;
			}
		}
	}

	// ������ǰ��������
	public void showBoy() {
		// �ж������Ƿ�Ϊ��
		if (first == null) {
			System.out.println("û���κ�С��");
			return;
		}

		// ��Ϊfirst���ܶ��������Ҫһ������ָ��������
		Boy curBoy = first;
		while (true) {
			System.out.printf("С���ı��%d \n", curBoy.getNo());
			if (curBoy.getNext() == first) {
				break;
			}
			curBoy = curBoy.getNext();
		}
	}

	// �����û������룬�����С����Ȧ��˳��
	/**
	 * 
	 * @param starNo   ��ʾ�ӵڼ���С����ʼ����
	 * @param countNum ��ʾ������
	 * @param nums     ��ʾ����ж��ٸ�С����Ȧ��
	 */
	public void countBoy(int startNo, int countNum, int nums) {
		// �ȶ����ݽ���У��
		if (first == null || startNo < 1 || startNo > nums) {
			System.out.println("����������������������");
			return;
		}
		// ����Ҫ������ָ�룬�������С����Ȧ
		Boy helper = first;
		// ����������ָ���б����
		while (true) {
			if (helper.getNext() == first) {
				break;
			}
			helper = helper.getNext();
		}
		// С������ǰ������first��helper�ƶ�k - 1��
		for(int i = 0; i < startNo - 1; i++) {
			first = first.getNext();
			helper = helper.getNext();
		}
		//��С������ʱ����first �� helper ָ��ͬʱ���ƶ�m - 1 �κ��ڣ�Ȼ���Ȧ
		while(true) {
			if (helper == first) {
				break;
			}
			// �� first ��helper ָ��ͬʱ���ƶ�countNum - 1
			for(int i = 0; i < countNum - 1; i++) {
				first = first.getNext();
				helper = helper.getNext();
			}
			//��ʱ first ָ��Ľڵ㣬����Ҫ��Ȧ��С���ڵ㡣
			System.out.printf("С��%d��Ȧ\n", first.getNo());
			//���ǽ�firstָ���С���ڵ��Ȧ
			first = first.getNext();
			helper.setNext(first);
		}
		System.out.printf("�������Ȧ�е�С���ǣ�%d",first.getNo());
	}

}

class Boy {
	private int no;
	private Boy next;

	public Boy(int no) {
		this.no = no;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public Boy getNext() {
		return next;
	}

	public void setNext(Boy next) {
		this.next = next;
	}

}