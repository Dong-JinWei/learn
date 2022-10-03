package com.dowei.likedlist;

public class DoubleLinkedListDemo {
	public static void main(String[] args) {
		System.out.println("˫������Ĳ���");
		//���в���
		//�ȴ����ڵ�
		HeroNode3 hero1 = new HeroNode3(1,"�ν�","��ʱ��");
		HeroNode3 hero2 = new HeroNode3(2,"¬����","������");
		HeroNode3 hero3 = new HeroNode3(3,"����","�Ƕ���");
		HeroNode3 hero4 = new HeroNode3(4,"�ֳ�","����ͷ");
		//����һ��˫������
		DoubleLinkedLisk doubleLinkedList = new DoubleLinkedLisk();
		doubleLinkedList.addByOrder(hero1);
		doubleLinkedList.addByOrder(hero4);
		doubleLinkedList.addByOrder(hero2);
		doubleLinkedList.addByOrder(hero3);
		doubleLinkedList.list();
		System.out.println();

//		//�޸�
//		HeroNode3 hero5 = new HeroNode3(4,"����ʤ","������");
//		doubleLinkedList.update(hero5);
//		System.out.println("�޸ĺ������Ϊ��");
//		doubleLinkedList.list();
//		
//		//ɾ��
//		doubleLinkedList.del(3);
//		System.out.println("ɾ���������Ϊ��");
//		doubleLinkedList.list();
		
	}
}

class DoubleLinkedLisk{
	
	//�ȳ�ʼ��һ��ͷ�ڵ㣬���ڵ㲻Ҫ��������ž�������ݡ�
	private HeroNode3 head = new HeroNode3(0,"","");
	
	public HeroNode3 getHead() {
		return head;
	}
	
	//����˫���б�
	public void list(){
		if(head.next == null) {
			System.out.println("����Ϊ��");
			return;
		}
		//��Ϊͷ�ڵ㲻�ܶ���Ӣ��������Ҫһ������������������
		HeroNode3 temp = head.next;
		while(true) {
			if (temp == null) {
				break;
			}
			System.out.println(temp);
			temp = temp.next;
		}
	}
	
	//���һ���ڵ㵽˫����������
	public void add(HeroNode3 heroNode) {
		//��Ϊhead�����ƶ��������Ҫһ�������������� temp
		HeroNode3 temp = head;
		//�����ҵ����
		while(true) {
			if (temp.next == null) {
				break;
			}
			//���û���ҵ���󣬽�temp����
			temp = temp.next;
		}
		// ���˳�whileѭ��ʱ��temp��ָ�����������
		//�γ�һ��˫������
		temp.next = heroNode;
		heroNode.pre = temp;
	}
	
	//�޸�һ���ڵ������
	public void update (HeroNode3 newHeroNode) {
		//�ж��Ƿ�Ϊ��
		if (head.next == null) {
			System.out.println("����Ϊ��");
			return;
		}
		//�ҵ���Ҫ�޸ĵĽڵ㣬����no��š�
		//����һ����������
		HeroNode3 temp = head.next;
		boolean flag = false;
		while(true) {
			if (temp == null) {
				break; //�����������
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
			System.out.printf("û���ҵ���� %d �Ľڵ㣬�����޸�\n", newHeroNode.no);
		}
	}
	
	//��˫�������У�ɾ���ڵ�
	//1. ����˫����������ֱ���ҵ�Ҫɾ��������ڵ�
	//2. �ҵ�������ɾ�����ɡ�
	public void del(int no) {
		if (head.next == null) {
			System.out.println("����Ϊ�գ��޷�ɾ��");
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
			System.out.println("Ҫɾ���Ľڵ㲻����");
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
			System.out.printf("%d��Ӣ��һ���ڣ��������\n", heroNode.no);
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
	public HeroNode3 pre; //ָ��ǰһ���ڵ�,Ĭ��Ϊnull

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