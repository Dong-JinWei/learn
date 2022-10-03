package com.dowei.tree.threadedbinarytree;

public class ThreadedBinaryTreeDemo {
	public static void main(String[] args) {
		HeroNode root = new HeroNode(1, "tom");
		HeroNode node2 = new HeroNode(3, "jack");
		HeroNode node3 = new HeroNode(6, "smith");
		HeroNode node4 = new HeroNode(8, "mary");
		HeroNode node5 = new HeroNode(10, "king");
		HeroNode node6 = new HeroNode(14, "dim");

		root.setLeft(node2);
		root.setRight(node3);
		node2.setLeft(node4);
		node2.setRight(node5);
		node3.setLeft(node6);

		ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
		threadedBinaryTree.setRoot(root);
		threadedBinaryTree.threadedNodes();

		// 测试: 以10号节点测试
		HeroNode leftNode = node5.getLeft();
		HeroNode rightNode = node5.getRight();
		System.out.println("10号结点的前驱结点是 =" + leftNode); // 3
		System.out.println("10号结点的后继结点是=" + rightNode); // 1

		// 当线索化二叉树后，能在使用原来的遍历方法
		// threadedBinaryTree.infixOrder();
		System.out.println("使用线索化的方式遍历 线索化二叉树");
		threadedBinaryTree.threadedList(); // 8, 3, 10, 1, 14, 6
	}
}

//定义ThreadedBinaryTree实现线索化二叉树
class ThreadedBinaryTree {
	private HeroNode root;

	private HeroNode pre = null;

	public void setRoot(HeroNode root) {
		this.root = root;
	}

	public void threadedNodes() {
		this.threadedNodes(root);
	}

	public void threadedList() {
		HeroNode node = root;
		while (node != null) {
			while (node.getLeftType() == 0) {
				node = node.getLeft();
			}
			System.out.println(node);
			while (node.getRightType() == 1) {
				node = node.getRight();
				System.out.println(node);
			}

			node = node.getRight();
		}
	}

	public void threadedNodes(HeroNode node) {
		if (node == null) {
			return;
		}

		threadedNodes(node.getLeft());
		if (node.getLeft() == null) {
			node.setLeft(pre);
			node.setLeftType(1);
		}

		if (pre != null && pre.getRight() == null) {
			pre.setRight(node);
			pre.setRightType(1);
		}
		pre = node;
		threadedNodes(node.getRight());
	}

	public void delNode(int no) {
		if (root != null) {
			if (root.getNo() == no) {
				root = null;
			} else {
				root.delNode(no);
			}
		} else {
			System.out.println("空树，不能删除~~");
		}
	}

	public void preOrder() {
		if (this.root != null) {
			this.root.preOrder();
		} else {
			System.out.println("二叉树为空，无法遍历");
		}
	}

	public void infixOrder() {
		if (this.root != null) {
			this.root.infixOrder();
		} else {
			System.out.println("二叉树为空，无法遍历");
		}
	}

	public void postOrder() {
		if (this.root != null) {
			this.root.postOrder();
		} else {
			System.out.println("二叉树为空，无法遍历");
		}
	}

	public HeroNode preOrderSearch(int no) {
		if (root != null) {
			return root.preOrderSearch(no);
		} else {
			return null;
		}
	}

	public HeroNode infixOrderSearch(int no) {
		if (root != null) {
			return root.infixOrderSearch(no);
		} else {
			return null;
		}
	}

	public HeroNode postOrderSearch(int no) {
		if (root != null) {
			return this.root.postOrderSearch(no);
		} else {
			return null;
		}
	}
}

//创建HeroNode 节点
class HeroNode {
	private int no;
	private String name;
	private HeroNode left;
	private HeroNode right;

	private int leftType;
	private int rightType;

	public HeroNode(int no, String name) {
		super();
		this.no = no;
		this.name = name;
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

	public int getLeftType() {
		return leftType;
	}

	public void setLeftType(int leftType) {
		this.leftType = leftType;
	}

	public int getRightType() {
		return rightType;
	}

	public void setRightType(int rightType) {
		this.rightType = rightType;
	}

	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + "]";
	}

	public void delNode(int no) {
		if (this.left != null && this.right.no == no) {
			this.left = null;
			return;
		}

		if (this.right != null && this.right.no == no) {
			this.right = null;
			return;
		}

		if (this.left != null) {
			this.left.delNode(no);
		}

		if (this.right != null) {
			this.right.delNode(no);
		}
	}

	// 编写前序遍历的方法
	public void preOrder() {
		System.out.println(this);// 先输出父节点
		// 递归向左子树前序遍历
		if (this.left != null) {
			this.left.preOrder();
		}
		// 递归向右子树前序遍历
		if (this.right != null) {
			this.right.preOrder();
		}
	}

	public void infixOrder() {
		if (this.left != null) {
			this.left.infixOrder();
		}
		System.out.println(this);
		if (this.right != null) {
			this.right.infixOrder();
		}
	}

	public void postOrder() {
		if (this.left != null) {
			this.left.postOrder();
		}
		if (this.right != null) {
			this.right.postOrder();
		}
		System.out.println(this);
	}

	public HeroNode preOrderSearch(int no) {
		System.out.println("进入前序遍历查找");

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

	public HeroNode infixOrderSearch(int no) {
		HeroNode resNode = null;
		if (this.left != null) {
			resNode = this.left.infixOrderSearch(no);
		}
		if (resNode != null) {
			return resNode;
		}
		if (this.no == no) {
			return this;
		}
		if (this.right != null) {
			resNode = this.right.infixOrderSearch(no);
		}
		return resNode;
	}

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
		if (this.no == no) {
			return this;
		}

		return resNode;
	}
}