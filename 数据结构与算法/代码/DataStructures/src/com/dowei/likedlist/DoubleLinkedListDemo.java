package com.dowei.likedlist;

public class DoubleLinkedListDemo {
	public static void main(String[] args) {
		System.out.println("双向链表的测试");
		//进行测试
		//先创建节点
		HeroNode3 hero1 = new HeroNode3(1,"宋江","及时雨");
		HeroNode3 hero2 = new HeroNode3(2,"卢俊义","玉麒麟");
		HeroNode3 hero3 = new HeroNode3(3,"吴用","智多星");
		HeroNode3 hero4 = new HeroNode3(4,"林冲","豹子头");
		//创建一个双向链表
		DoubleLinkedLisk doubleLinkedList = new DoubleLinkedLisk();
		doubleLinkedList.addByOrder(hero1);
		doubleLinkedList.addByOrder(hero4);
		doubleLinkedList.addByOrder(hero2);
		doubleLinkedList.addByOrder(hero3);
		doubleLinkedList.list();
		System.out.println();

//		//修改
//		HeroNode3 hero5 = new HeroNode3(4,"公孙胜","入云龙");
//		doubleLinkedList.update(hero5);
//		System.out.println("修改后的链表为：");
//		doubleLinkedList.list();
//		
//		//删除
//		doubleLinkedList.del(3);
//		System.out.println("删除后的链表为：");
//		doubleLinkedList.list();
		
	}
}

class DoubleLinkedLisk{
	
	//先初始化一个头节点，他节点不要动，不存放具体的数据。
	private HeroNode3 head = new HeroNode3(0,"","");
	
	public HeroNode3 getHead() {
		return head;
	}
	
	//遍历双向列表
	public void list(){
		if(head.next == null) {
			System.out.println("链表为空");
			return;
		}
		//因为头节点不能动，英雌我们需要一个辅助变量来遍历。
		HeroNode3 temp = head.next;
		while(true) {
			if (temp == null) {
				break;
			}
			System.out.println(temp);
			temp = temp.next;
		}
	}
	
	//添加一个节点到双向链表的最后，
	public void add(HeroNode3 heroNode) {
		//因为head不能移动，因此需要一个辅助辅助变量 temp
		HeroNode3 temp = head;
		//遍历找到最后。
		while(true) {
			if (temp.next == null) {
				break;
			}
			//如果没有找到最后，将temp后移
			temp = temp.next;
		}
		// 当退出while循环时，temp就指向了链表最后。
		//形成一个双向链表
		temp.next = heroNode;
		heroNode.pre = temp;
	}
	
	//修改一个节点的内容
	public void update (HeroNode3 newHeroNode) {
		//判断是否为空
		if (head.next == null) {
			System.out.println("链表为空");
			return;
		}
		//找到需要修改的节点，根据no编号。
		//定义一个辅助变量
		HeroNode3 temp = head.next;
		boolean flag = false;
		while(true) {
			if (temp == null) {
				break; //遍历完成链表
			}
			if (temp.no == newHeroNode.no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if (flag) {
			temp.name = newHeroNode.name;
			temp.nickname = newHeroNode.nickname;
		}else {
			System.out.printf("没有找到编号 %d 的节点，不能修改\n", newHeroNode.no);
		}
	}
	
	//从双向链表中，删除节点
	//1. 对于双向链表，可以直接找到要删除的这个节点
	//2. 找到后，自我删除即可。
	public void del(int no) {
		if (head.next == null) {
			System.out.println("链表为空，无法删除");
			return;
		}
		
		HeroNode3 temp = head.next;
		boolean flag = false;
		while(true) {
			if(temp == null) {
				break;
			}
			if (temp.no == no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if(flag) {
			temp.pre.next = temp.next;
			if (temp.next != null) {
				temp.next.pre = temp.pre;
			}
			
		}else {
			System.out.println("要删除的节点不存在");
		}
	}
	
	public void addByOrder(HeroNode3 heroNode) {
		HeroNode3 temp = head;
		boolean flag = false;
		
		while(true) {
			if(temp.next == null) {
				break;
			}
			if (temp.next.no > heroNode.no) {
				break;
			}
			if(temp.next.no == heroNode.no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if(flag) {
			System.out.printf("%d号英雄一存在，不能添加\n", heroNode.no);
		}else {
			if(temp.next == null) {
				temp.next = heroNode;
				heroNode.pre = temp;
			}else {
				heroNode.pre = temp.next.pre;
				heroNode.next = temp.next;
				temp.next = heroNode;
			}
			
		}
	}
	 
}

class HeroNode3 {
	public int no;
	public String name;
	public String nickname;
	public HeroNode3 next;
	public HeroNode3 pre; //指向前一个节点,默认为null

	public HeroNode3(int no, String name, String nickname) {
		this.no = no;
		this.name = name;
		this.nickname = nickname;
	}
	

 
	@Override
	public String toString() {
		return "HeroNode3 [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
	}

}