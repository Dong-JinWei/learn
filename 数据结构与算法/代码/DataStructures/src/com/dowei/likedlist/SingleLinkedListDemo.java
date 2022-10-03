package com.dowei.likedlist;

public class SingleLinkedListDemo {

	public static void main(String[] args) {
		
		//���в���
		//�ȴ����ڵ�
		HeroNode hero1 = new HeroNode(1,"�ν�","��ʱ��");
		HeroNode hero2 = new HeroNode(2,"¬����","������");
		HeroNode hero3 = new HeroNode(3,"����","�Ƕ���");
		HeroNode hero4 = new HeroNode(4,"�ֳ�","����ͷ");
		
		//��������
		SingleLinkedList singleLinkedList = new SingleLinkedList();
		//����
		singleLinkedList.add(hero1);
		singleLinkedList.add(hero4);
		singleLinkedList.add(hero2);
		singleLinkedList.add(hero3);
		
		
		//��ʾ
		singleLinkedList.list();
	}

}

//���� SingleLinkedList �������ǵ�Ӣ��
class SingleLinkedList {
	//�ȳ�ʼ��һ��ͷ�ڵ㣬ͷ�ڵ㲻Ҫ��������ž��������
	private HeroNode head =  new HeroNode(0,"","");
	
	//��ӽڵ㵽��������
	//˼·��������Ҫ���Ǳ��˳��ʱ
	//1. �ҵ���ǰ��������ڵ�
	//2. ���������ڵ��next ָ�� �µĽڵ�
	public void add(HeroNode heroNode) {
		//��Ϊͷ�ڵ�head���ܶ���Ӣ��������Ҫһ���������� temp
		HeroNode temp = head;
		//���������ҵ����
		while(true) {
			//�ҵ���������
			if(temp.next == null) {
				break;
			}
			//���û���ҵ���󣬽�temp����
			temp = temp.next;
		}
		//���˳�whileѭ��ʱ��temp��ָ������������
		//���������ڵ��nextָ���½ڵ�
		temp.next  = heroNode;
	}
	//������ʾ����
	public void list() {
		//�ж��Ƿ�Ϊ��
		if (head.next == null) {
			System.out.println("����Ϊ��");
			return;
		}
		//��Ϊͷ�ڵ㣬���ܶ������Ѱ��һ����������������
		HeroNode temp = head.next;
		while(true) {
			//�ж��Ƿ��������
			if(temp == null) {
				break;
			}
			//����ڵ����Ϣ
			System.out.println(temp);
			//��next����
			temp = temp.next;
		}
	}
}


//����HeroNode ��ÿ�� HeroNode �������һ���ڵ�
class HeroNode{
	public int no;
	public String name;
	public String nickname;
	public HeroNode next;  //ָ����һ���ڵ�
	
	//������
	public HeroNode(int no, String name, String nickname) {
		this.no = no;
		this.name = name;
		this.nickname = nickname;
	}
	
	//Ϊ����ʾ���㣬��д toString ����
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
	}
	
	
	
}
