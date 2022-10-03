package com.dowei.huffmancode;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HuffmanCode {
	public static void main(String[] args) {

		// ���Խ�ѹ�ļ�
		String srcFile = "D:\\demo\\stc.zip";
		String dstFile = "D:\\demo\\1123.png";
		unZipFile(srcFile, dstFile);
		System.out.println("�����ɹ�");

//		//����ѹ���ļ�
//		String srcFile = "D:\\demo\\stc.png";
//		String dstFile = "D:\\demo\\stc.zip";
//		zipFile(srcFile, dstFile);
//		System.out.println("ѹ���ɹ�");

//		String content = "i like like like java do you like a java";
//		byte[] contentBytes = content.getBytes();
//		System.out.println(contentBytes.length); // 40
//
//		byte[] huffmanCodesBytes = huffmanZip(contentBytes);
//		System.out.println("ѹ����Ľ����:" + Arrays.toString(huffmanCodesBytes) + " ����= " + huffmanCodesBytes.length);
//
//		// ����һ��byteToBitString����
//		// System.out.println(byteToBitString((byte)1));
//		byte[] sourceBytes = decode(huffmanCodes, huffmanCodesBytes);
//
//		System.out.println("ԭ�����ַ���=" + new String(sourceBytes)); // "i like like like java do you like a java"

//		List<Node> nodes = getNodes(contentBytes);
//		System.out.println("nodes = " + nodes);
//
//		// ����һ�ѣ������ĺշ�����
//		System.out.println("�շ�����");
//		Node huffmanTreeRoot = createHuffmanTree(nodes);
//		System.out.println("ǰ�����");
//		huffmanTreeRoot.preOrder();
//
////		getCodes(huffmanTreeRoot, "", stringBuilder);
//		Map<Byte, String> huffmanCodes = getCodes(huffmanTreeRoot);
//		System.out.println("���ɵĹ����������" + huffmanCodes);
//		
//		byte[] huffmanCodeBytes = zip(contentBytes, huffmanCodes);
//		System.out.println("huffmanCodeBytes=" + Arrays.toString(huffmanCodeBytes));
//		System.out.println(huffmanCodeBytes.length);

	}

	static Map<Byte, String> huffmanCodes = new HashMap<Byte, String>();
	static StringBuilder stringBuilder = new StringBuilder();

	public static void unZipFile(String zipFile, String dstFile) {

		// �����ļ�������
		InputStream is = null;
		// ����һ������������
		ObjectInputStream ois = null;
		// �����ļ��������
		OutputStream os = null;
		try {
			// �����ļ�������
			is = new FileInputStream(zipFile);
			// ����һ���� is�����Ķ���������
			ois = new ObjectInputStream(is);
			// ��ȡbyte���� huffmanBytes
			byte[] huffmanBytes = (byte[]) ois.readObject();
			// ��ȡ�շ��������
			Map<Byte, String> huffmanCodes = (Map<Byte, String>) ois.readObject();

			// ����
			byte[] bytes = decode(huffmanCodes, huffmanBytes);
			// ��bytes ����д�뵽Ŀ���ļ�
			os = new FileOutputStream(dstFile);
			// д���ݵ� dstFile �ļ�
			os.write(bytes);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} finally {

			try {
				os.close();
				ois.close();
				is.close();
			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println(e2.getMessage());
			}

		}
	}

	public static void zipFile(String srcFile, String dstFile) {

		// ���������
		OutputStream os = null;
		ObjectOutputStream oos = null;
		// �����ļ���������
		FileInputStream is = null;
		try {
			// �����ļ���������
			is = new FileInputStream(srcFile);
			// ����һ����Դ�ļ���Сһ����byte[]
			byte[] b = new byte[is.available()];
			// ��ȡ�ļ�
			is.read(b);
			// ֱ�Ӷ�Դ�ļ�ѹ��
			byte[] huffmanBytes = huffmanZip(b);
			// �����ļ��������, ���ѹ���ļ�
			os = new FileOutputStream(dstFile);
			// ����һ�����ļ������������ObjectOutputStream
			oos = new ObjectOutputStream(os);
			// �� �շ����������ֽ�����д��ѹ���ļ�
			oos.writeObject(huffmanBytes); // �����ǰ�
			// ���������Զ������ķ�ʽд�� �շ������룬��Ϊ���Ժ����ǻָ�Դ�ļ�ʱʹ��
			// ע��һ��Ҫ�Ѻշ������� д��ѹ���ļ�
			oos.writeObject(huffmanCodes);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} finally {
			try {
				is.close();
				oos.close();
				os.close();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		}

	}

	private static byte[] decode(Map<Byte, String> huffmanCodes, byte[] huffmanBytes) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < huffmanBytes.length; i++) {
			byte b = huffmanBytes[i];
			boolean flag = (i == huffmanBytes.length - 1);
			stringBuilder.append(byteToBitString(!flag, b));
		}
		Map<String, Byte> map = new HashMap<String, Byte>();
		for (Map.Entry<Byte, String> entry : huffmanCodes.entrySet()) {
			map.put(entry.getValue(), entry.getKey());
		}

		List<Byte> list = new ArrayList<>();
		for (int i = 0; i < stringBuilder.length();) {
			int count = 1;
			boolean flag = true;
			Byte b = null;

			while (flag) {
				String key = stringBuilder.substring(i, i + count);
				b = map.get(key);
				if (b == null) {
					count++;
				} else {
					flag = false;
				}
			}
			list.add(b);
			i += count;
		}

		byte b[] = new byte[list.size()];
		for (int i = 0; i < b.length; i++) {
			b[i] = list.get(i);
		}
		return b;
	}

	private static String byteToBitString(boolean flag, byte b) {
		int temp = b;
		if (flag) {
			temp |= 256;
		}
		String str = Integer.toBinaryString(temp);
		if (flag) {
			return str.substring(str.length() - 8);
		} else {
			return str;
		}
	}

	private static byte[] huffmanZip(byte[] bytes) {
		List<Node> nodes = getNodes(bytes);
		Node huffmanTreeRoot = createHuffmanTree(nodes);
		Map<Byte, String> huffmanCodes = getCodes(huffmanTreeRoot);
		byte[] huffmanCodeBytes = zip(bytes, huffmanCodes);
		return huffmanCodeBytes;
	}

	private static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {
		StringBuilder stringBuilder = new StringBuilder();
		for (byte b : bytes) {
			stringBuilder.append(huffmanCodes.get(b));
		}
		int len;
		if (stringBuilder.length() % 8 == 0) {
			len = stringBuilder.length() / 8;
		} else {
			len = stringBuilder.length() / 8 + 1;
		}
		byte[] huffmanCodeBytes = new byte[len];
		int index = 0;
		for (int i = 0; i < stringBuilder.length(); i += 8) {
			String strByte;
			if (i + 8 > stringBuilder.length()) {
				strByte = stringBuilder.substring(i);
			} else {
				strByte = stringBuilder.substring(i, i + 8);
			}
			huffmanCodeBytes[index] = (byte) Integer.parseInt(strByte, 2);
			index++;
		}
		return huffmanCodeBytes;
	}

	private static Map<Byte, String> getCodes(Node root) {
		if (root == null) {
			return null;
		}

		getCodes(root.left, "0", stringBuilder);
		getCodes(root.right, "1", stringBuilder);

		return huffmanCodes;
	}

	private static void getCodes(Node node, String code, StringBuilder stringBuilder) {
		StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
		stringBuilder2.append(code);
		if (node != null) {
			if (node.data == null) {
				getCodes(node.left, "0", stringBuilder2);
				getCodes(node.right, "1", stringBuilder2);
			} else {
				huffmanCodes.put(node.data, stringBuilder2.toString());
			}
		}
	}

	private static void preOrder(Node root) {
		if (root != null) {
			root.preOrder();
		} else {
			System.out.println("��������Ϊ��~~");
		}

	}

	private static List<Node> getNodes(byte[] bytes) {

		ArrayList<Node> nodes = new ArrayList<Node>();
		Map<Byte, Integer> counts = new HashMap<>();
		for (byte b : bytes) {
			Integer count = counts.get(b);
			if (count == null) {
				counts.put(b, 1);
			} else {
				counts.put(b, count + 1);
			}
		}

		for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
			nodes.add(new Node(entry.getKey(), entry.getValue()));
		}
		return nodes;
	}

	private static Node createHuffmanTree(List<Node> nodes) {
		while (nodes.size() > 1) {
			Collections.sort(nodes);
			Node leftNode = nodes.get(0);
			Node rightNode = nodes.get(1);
			Node parent = new Node(null, leftNode.weight + rightNode.weight);
			parent.left = leftNode;
			parent.right = rightNode;
			nodes.remove(leftNode);
			nodes.remove(rightNode);
			nodes.add(parent);
		}
		return nodes.get(0);
	}
}

class Node implements Comparable<Node> {
	Byte data;
	int weight;
	Node left;
	Node right;

	public Node(Byte data, int weight) {
		this.data = data;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return this.weight - o.weight;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", weight=" + weight + "]";
	}

	public void preOrder() {
		System.out.println(this);
		if (this.left != null) {
			this.left.preOrder();
		}
		if (this.right != null) {
			this.right.preOrder();
		}
	}

}