package com.dowei.tree;

public class BinaryTreeDemo {
	public static void main(String[] args) {
		// 先创建一颗二叉树
		BinaryTree binaryTree = new BinaryTree();
		// 创建需要的结点
		HeroNode root = new HeroNode(1, "宋江");
		HeroNode node2 = new HeroNode(2, "吴用");
		HeroNode node3 = new HeroNode(3, "卢俊义");
		HeroNode node4 = new HeroNode(4, "林冲");
		HeroNode node5 = new HeroNode(5, "关胜");

		// 说明，我们先手动创建该二叉树，后面我们学习递归的方式创建二叉树
		root.setLeft(node2);
		root.setRight(node3);
		node3.setRight(node4);
		node3.setLeft(node5);
		binaryTree.setRoot(root);

////		测试
//		System.out.println("前序遍历"); // 1,2,3,5,4
//		binaryTree.preOrder();
//		
////		测试 
//		System.out.println("中序遍历");
//		binaryTree.infixOrder(); // 2,1,5,3,4
//		
//		System.out.println("后序遍历");
//		binaryTree.postOrder(); // 2,5,4,3,1

//		//前序遍历
//		System.out.println("前序遍历方式~~~~~");
//		HeroNode resNode = binaryTree.preOrderSearch(5);
//		if (resNode != null) {
//			System.out.printf("找到了，信息为 no=%d name=%s", resNode.getNo(), resNode.getName());	
//		}else {
//			System.out.printf("没有找到 no = %d 的英雄", 5);
//		}
//		
//		// 中序遍历
//		System.out.println("中序遍历方式~~~~~");
//		HeroNode resNode = binaryTree.infixOrderSearch(5);
//		if (resNode != null) {
//			System.out.printf("找到了，信息为 no=%d name=%s", resNode.getNo(), resNode.getName());
//		} else {
//			System.out.printf("没有找到 no = %d 的英雄", 5);
//		}
		
		// 后序遍历
		System.out.println("后序遍历方式~~~~~");
		HeroNode resNode = binaryTree.postOrderSearch(5);
		if (resNode != null) {
			System.out.printf("找到了，信息为 no=%d name=%s", resNode.getNo(), resNode.getName());
		} else {
			System.out.printf("没有找到 no = %d 的英雄", 5);
		}

	}

}

//定义BinaryTree 二叉树
class BinaryTree {
	private HeroNode root;

	public void setRoot(HeroNode root) {
		this.root = root;
	}

	// 先序遍历
	public void preOrder() {
		if (this.root != null) {
			this.root.preOrder();
		} else {
			System.out.println("二叉树为空，无法遍历");
		}
	}

	// 中序遍历
	public void infixOrder() {
		if (this.root != null) {
			this.root.infixOrder();
		} else {
			System.out.println("二叉树为空，无法遍历");
		}
	}

	// 后续遍历
	public void postOrder() {
		if (this.root != null) {
			this.root.postOrder();
		} else {
			System.out.println("二叉树为空，无法遍历");
		}
	}

	// 先序查找
	public HeroNode preOrderSearch(int no) {
		if (root != null) {
			return root.preOrderSearch(no);
		} else {
			return null;
		}
	}

	// 中序遍历
	public HeroNode infixOrderSearch(int no) {
		if (root != null) {
			return root.infixOrderSearch(no);
		} else {
			return null;
		}
	}

	// 后续遍历
	public HeroNode postOrderSearch(int no) {
		if (root != null) {
			return this.root.postOrderSearch(no);
		} else {
			return null;
		}
	}

}

class HeroNode {
	private int no;
	private String name;
	private HeroNode left;
	private HeroNode right;

	public HeroNode(int no, String name) {
		this.no = no;
		this.name = name;
	}

	// 先序遍历方法
	public void preOrder() {
		// TODO Auto-generated method stub
		System.out.println(this);
		if (this.left != null) {
			this.left.preOrder();
		}
		if (this.right != null) {
			this.right.preOrder();
		}
	}

	// 中序遍历
	public void infixOrder() {
		if (this.left != null) {
			this.left.infixOrder();
		}
		// 输出父节点
		System.out.println(this);

		if (this.right != null) {
			this.right.infixOrder();
		}
	}

	// 后续遍历
	public void postOrder() {
		if (this.left != null) {
			this.left.postOrder();
		}
		if (this.right != null) {
			this.right.postOrder();
		}
		System.out.println(this);
	}

	// 前序遍历查找
	public HeroNode preOrderSearch(int no) {
		System.out.println("进入前序遍历");
		// 比较当前节点是不是
		if (this.no == no) {
			return this;
		}

		HeroNode resNode = null;
		if (this.left != null) {
			resNode = this.left.preOrderSearch(no);
		}
		if (resNode != null) {
			return resNode;
		}

		if (this.right != null) {
			resNode = this.right.preOrderSearch(no);
		}
		return resNode;
	}

	// 中序查找
	public HeroNode infixOrderSearch(int no) {
		HeroNode resNode = null;
		if (this.left != null) {
			resNode = this.left.infixOrderSearch(no);
		}
		if (resNode != null) {
			return resNode;
		}
		System.out.println("进入中序查找");
		if (this.no == no) {
			return this;
		}

		if (this.right != null) {
			resNode = this.right.infixOrderSearch(no);
		}
		return resNode;
	}

	// 后续遍历查找
	public HeroNode postOrderSearch(int no) {
		HeroNode resNode = null;
		if (this.left != null) {
			resNode = this.left.postOrderSearch(no);
		}
		if (resNode != null) {
			return resNode;
		}

		if (this.right != null) {
			resNode = this.right.postOrderSearch(no);
		}
		if (resNode != null) {
			return resNode;
		}
		System.out.println("进入后续查找");
		if (this.no == no) {
			return this;
		}
		return resNode;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HeroNode getLeft() {
		return left;
	}

	public void setLeft(HeroNode left) {
		this.left = left;
	}

	public HeroNode getRight() {
		return right;
	}

	public void setRight(HeroNode right) {
		this.right = right;
	}

	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + "]";
	}

}