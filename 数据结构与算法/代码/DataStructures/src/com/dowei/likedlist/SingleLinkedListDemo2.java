package com.dowei.likedlist;

import java.util.Stack;

public class SingleLinkedListDemo2 {
	public static void main(String[] args) {
		// ���в���
		// �ȴ����ڵ�
		HeroNode2 hero1 = new HeroNode2(1, "�ν�", "��ʱ��");
		HeroNode2 hero2 = new HeroNode2(2, "¬����", "������");
		HeroNode2 hero3 = new HeroNode2(3, "����", "�Ƕ���");
		HeroNode2 hero4 = new HeroNode2(4, "�ֳ�", "����ͷ");
		HeroNode2 hero5 = new HeroNode2(5, "����", "������");
		HeroNode2 hero6 = new HeroNode2(6, "��6", "��6");
		HeroNode2 hero7 = new HeroNode2(7, "��7", "��7");
		HeroNode2 hero8 = new HeroNode2(8, "��8", "��8");
		HeroNode2 hero9 = new HeroNode2(9, "��9", "��9");
		
		SingleLinkedList2 singleLinkedList2 = new SingleLinkedList2();
		
//		singleLinkedList2.add2(hero1);
//		singleLinkedList2.add2(hero2);
//		singleLinkedList2.add2(hero3);
//		singleLinkedList2.add2(hero4);
		
		singleLinkedList2.addByOrder2(hero1);
		singleLinkedList2.addByOrder2(hero2);
		singleLinkedList2.addByOrder2(hero3);
		singleLinkedList2.addByOrder2(hero4);
		singleLinkedList2.addByOrder2(hero5);
		singleLinkedList2.addByOrder2(hero5);
		singleLinkedList2.addByOrder2(hero6);
		singleLinkedList2.addByOrder2(hero7);
		singleLinkedList2.addByOrder2(hero8);
		singleLinkedList2.addByOrder2(hero9);
		
		singleLinkedList2.list2();
		
		System.out.println("��ת������");
//		SingleLinkedList2.reverseList(singleLinkedList2.getHead());
//		singleLinkedList2.list2();
		SingleLinkedList2.reversePrint(singleLinkedList2.getHead());
		
//		System.out.println("�޸�ǰ��");
//		singleLinkedList2.list2();
		
		//singleLinkedList2.delete2(1);
		
//		System.out.println("�޸ĺ�");
//		singleLinkedList2.list2();
		
//		int n = SingleLinkedList2.getLength(singleLinkedList2.getHead());
//		System.out.println(n);
//		HeroNode2 res = SingleLinkedList2.findLastIndexNode(singleLinkedList2.getHead(), 5);
//		System.out.println(" ���ҵ�Ԫ��Ϊ"+ res);
		
		
	}
}

class SingleLinkedList2 {
	private HeroNode2 head = new HeroNode2(0, "", "");
	
	public HeroNode2 getHead() {
		return head;
	}

	public void add2(HeroNode2 heroNode2) {
		HeroNode2 temp = head;
		while (true) {
			if (temp.next == null) {
				temp.next = heroNode2;
				break;
			}
			temp = temp.next;
		}
	}
	
	public void addByOrder2(HeroNode2 heroNode2) {
		HeroNode2 temp = head;
		boolean flag = false;
		
		while(true) {
			if(temp.next == null) {
				break;
			}
			if (temp.next.no > heroNode2.no) {
				break;
			}
			if(temp.next.no == heroNode2.no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if(flag) {
			System.out.printf("%d��Ӣ���Ѵ��ڣ��������\n", heroNode2.no);
		}else {
			heroNode2.next = temp.next;
			temp.next = heroNode2;
		}
		
	}
	
	//�޸Ľڵ�
	public void update2(HeroNode2 newHeroNode2) {
		if (head.next == null) {
			System.out.println("����Ϊ��");
			return;
		}
		HeroNode2 temp = head.next;
		boolean flag = false;
		while(true) {
			if (temp == null) {
				break;
			}
			if (temp.no == newHeroNode2.no) {
				flag = true;
				break;
			}
			
			
			temp = temp.next;
		}
		if (flag) {
			temp.name = newHeroNode2.name;
			temp.nickname = newHeroNode2.nickname;
		}else {
			System.out.printf("û���ҵ�%d��Ӣ�ۣ������޸�\n", newHeroNode2.no);
		}
	}
	
	public void delete2(int no) {
		if (head.next == null) {
			System.out.println("����Ϊ�գ�����ɾ����");
			return;
		}
		HeroNode2 temp = head;
		boolean flag = false;
		while(true) {
			if (temp.next == null) {
				break;
			}
			if (no == temp.next.no) {
				flag = true;
				break;
			}			
			temp = temp.next;
		}
		if (flag) {
			temp.next = temp.next.next;
		}else {
			System.out.printf("û���ҵ�%d��Ӣ�ۣ�����ɾ��\n", no);
			
		}
		
	}

	/// ��ʾ����
	public void list2() {
		if (head.next == null) {
			System.out.println("����Ϊ��");
			return;
		}
		HeroNode2 temp = head.next;
		while (true) {
			if (temp == null) {
				break;
			}
			System.out.println(temp.toString());
			temp = temp.next;
		}
	}
	
	//��������ȡ������ڵ�ĸ���
	public static int getLength(HeroNode2 head) {
		if (head.next == null) {
			return 0;
		}
		int length = 0;
		HeroNode2 cur = head.next;
		while(cur != null) {
			length++;
			cur = cur.next;
		}
		return length;
	}
	//���������еĵ�����k�����
	public static HeroNode2 findLastIndexNode(HeroNode2 head, int index) {
		if(head.next == null) {
			return null;
		}
		int size = getLength(head);
		if (index <= 0 || index > size) {
			return null;
		}
		HeroNode2 cur = head.next;
		for (int i = 0; i < size - index; i++) {
			cur = cur.next;
		} 
		return cur;
	}
	
	//��ת����
	public static void reverseList(HeroNode2 head) {
		if (head.next == null || getLength(head) == 1) {
			return;
		}
		//���帨��ָ��
		HeroNode2 cur = head.next;
		HeroNode2 next = null;
		HeroNode2 reverseHead = new HeroNode2(0,"","");
		while(cur != null) {
			next = cur;
			cur = cur.next;
			next.next = reverseHead.next;
			reverseHead.next = next;			
			
//			next = cur.next;
//			cur.next = reverseHead.next;
//			reverseHead.next = cur;
//			cur = next;
		}
		head.next = reverseHead.next;
	}
	//��ʽ2
	//ʹ��ջ���ֽṹ����ת�б�
	public static void reversePrint(HeroNode2 head) {
		if (head.next == null) {
			return;
		}
		Stack<HeroNode2> stack = new Stack<HeroNode2>();
		HeroNode2 cur = head.next;
		while(cur != null) {
			stack.push(cur);
			cur = cur.next;
		}
		while (stack.size() > 0) {
			System.out.println(stack.pop());
		}
	}
	
	
}

class HeroNode2 {
	public int no;
	public String name;
	public String nickname;
	public HeroNode2 next;

	public HeroNode2(int no, String name, String nickname) {
		this.no = no;
		this.name = name;
		this.nickname = nickname;
	}
	

 
	@Override
	public String toString() {
		return "HeroNode2 [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
	}

}