package com.dowei.kruskal;

import java.util.Arrays;

public class KruskalCase {
	private int edgeNum;
	private char[] vertexs;
	private int[][] matrix;
	private static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) {
		char[] vertexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
			//��³˹�����㷨���ڽӾ���  
		int matrix[][] = {
		      /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
		/*A*/ {   0,  12, INF, INF, INF,  16,  14},
		/*B*/ {  12,   0,  10, INF, INF,   7, INF},
		/*C*/ { INF,  10,   0,   3,   5,   6, INF},
		/*D*/ { INF, INF,   3,   0,   4, INF, INF},
		/*E*/ { INF, INF,   5,   4,   0,   2,   8},
		/*F*/ {  16,   7,   6, INF,   2,   0,   9},
		/*G*/ {  14, INF, INF, INF,   8,   9,   0}};
		
		KruskalCase kruskalCase = new KruskalCase(vertexs, matrix);
		kruskalCase.print();
		
		EData[] edges = kruskalCase.getEdges();
		System.out.println("δ����" + Arrays.toString(edges));
		kruskalCase.sortEdges(edges);
		System.out.println("�����" + Arrays.toString(edges));
	}
	
	public void kruskal() {
		int index = 0;
		int[] ends = new int[edgeNum];
		EData[] rets = new EData[edgeNum];
		EData[] edges = getEdges();
		System.out.println("ͼ�ıߵļ���=" + Arrays.toString(edges) + "��" + edges.length );
		sortEdges(edges);
		
		for (int i = 0; i < edgeNum; i++) {
			int p1 = getPosition(edges[i].start);
			int p2 = getPosition(edges[i].end);
			
			int m = getEnd(ends, p1);
			int n = getEnd(ends, p2);
			
			if(m != n) {
				ends[m] = n;
				rets[index++] = edges[i];
			}
			
		}
		
	}

	public KruskalCase(char[] vertexs, int[][] matrix) {
		int vlen = vertexs.length;
		this.vertexs = new char[vlen];
		for (int i = 0; i < vertexs.length; i++) {
			this.vertexs[i] = vertexs[i];
		}

		this.matrix = new int[vlen][vlen];
		for (int i = 0; i < vlen; i++) {
			for (int j = 0; j < vlen; j++) {
				this.matrix[i][j] = matrix[i][j];
			}
		}
		
		for (int i = 0; i < vlen; i++) {
			for (int j = i + 1; j < vlen; j++) {
				if (this.matrix[i][j] != INF) {
					edgeNum++;
				}
			}
		}
	}
	
	public void print() {
		System.out.println("�ڽӾ���Ϊ��\n");
		for(int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.printf("%12d", matrix[i][j]);
			}
			System.out.println();
		}
	}
	
	public void sortEdges(EData[] edges) {
		for(int i = 0; i < edges.length - 1; i++) {
			for(int j = 0; j < edges.length - 1 - i; j++) {
				if (edges[j].weight > edges[j + 1].weight) {
					EData temp = edges[j];
					edges[j] = edges[j + 1];
					edges[j + 1] = temp;
				}
			}
		}
	}
	
	public int getPosition(char ch) {
		for (int i = 0; i < vertexs.length; i++) {
			if (ch == vertexs[i]) {
				return i;
			}
		}
		return -1;
	}

	private EData[] getEdges() {
		int index = 0;
		EData[] edges = new EData[edgeNum];
		for(int i = 0; i < vertexs.length; i++) {
			for (int j = i + 1; j < vertexs.length; j++) {
				if (matrix[i][j] != INF) {
					edges[index++] = new  EData(vertexs[i], vertexs[j], matrix[i][j]);
				}
			}
		}
		return edges;
	}
	
	private int getEnd(int[] ends, int i) {
		while(ends[i] != 0) {
			i = ends[i];
		}
		return i;
	}

}

class EData {
	char start;
	char end;
	int weight;
	
	public EData(char start, char end, int weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}
	
	public String toString() {
		return "EData [<" + start + ", " + end + ">= " + weight + "]";
	}
}
