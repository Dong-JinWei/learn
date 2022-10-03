package com.dowei.likedlist;

import java.util.Stack;

public class SingleLinkedListDemo2 {
	public static void main(String[] args) {
		// 进行测试
		// 先创建节点
		HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
		HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
		HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
		HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");
		HeroNode2 hero5 = new HeroNode2(5, "李逵", "黑旋风");
		HeroNode2 hero6 = new HeroNode2(6, "李6", "黑6");
		HeroNode2 hero7 = new HeroNode2(7, "李7", "黑7");
		HeroNode2 hero8 = new HeroNode2(8, "李8", "黑8");
		HeroNode2 hero9 = new HeroNode2(9, "李9", "黑9");
		
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
		
		System.out.println("反转单链表");
//		SingleLinkedList2.reverseList(singleLinkedList2.getHead());
//		singleLinkedList2.list2();
		SingleLinkedList2.reversePrint(singleLinkedList2.getHead());
		
//		System.out.println("修改前：");
//		singleLinkedList2.list2();
		
		//singleLinkedList2.delete2(1);
		
//		System.out.println("修改后：");
//		singleLinkedList2.list2();
		
//		int n = SingleLinkedList2.getLength(singleLinkedList2.getHead());
//		System.out.println(n);
//		HeroNode2 res = SingleLinkedList2.findLastIndexNode(singleLinkedList2.getHead(), 5);
//		System.out.println(" 查找的元素为"+ res);
		
		
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
			System.out.printf("%d号英雄已从在！不能添加\n", heroNode2.no);
		}else {
			heroNode2.next = temp.next;
			temp.next = heroNode2;
		}
		
	}
	
	//修改节点
	public void update2(HeroNode2 newHeroNode2) {
		if (head.next == null) {
			System.out.println("链表为空");
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
			System.out.printf("没有找到%d号英雄，不能修改\n", newHeroNode2.no);
		}
	}
	
	public void delete2(int no) {
		if (head.next == null) {
			System.out.println("链表为空，不能删除！");
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
			System.out.printf("没有找到%d号英雄，不能删除\n", no);
			
		}
		
	}

	/// 显示链表
	public void list2() {
		if (head.next == null) {
			System.out.println("链表为空");
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
	
	//方法，获取单链表节点的个数
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
	//查找链表中的倒数第k个结点
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
	
	//反转链表
	public static void reverseList(HeroNode2 head) {
		if (head.next == null || getLength(head) == 1) {
			return;
		}
		//定义辅助指针
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
	//方式2
	//使用栈这种结构，反转列表
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