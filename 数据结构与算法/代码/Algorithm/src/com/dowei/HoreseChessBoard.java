package com.dowei;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Comparator;

public class HoreseChessBoard {
	private static int X;
	private static int Y;
	private static boolean visited[];
	private static boolean finished;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("��ʿ�����㷨����ʼ����~~");
		// ������ʿ�����㷨�Ƿ���ȷ
		X = 8;
		Y = 8;
		int row = 5; // �����ʼλ�õ��У���1��ʼ���
		int column = 1 ; // �����ʼλ�õ��У���1��ʼ���
		int[][] chessboard = new int[X][Y];
		visited = new boolean[X * Y];// ��ʼֵ����false
		long start = System.currentTimeMillis();
		traversalChessboard(chessboard, row - 1, column - 1, 1);
		long end = System.currentTimeMillis();
		System.out.println("����ʱ: " + (end - start) + " ����");

		// ������̵�������
		for (int[] rows : chessboard) {
			for (int step : rows) {
				System.out.print(step + "\t");
			}
			System.out.println();
		}
	}

	public static void traversalChessboard(int[][] chessboard, int row, int column, int step) {
		chessboard[row][column] = step;
		visited[row * X + column] = true;
		ArrayList<Point> ps = next(new Point(column, row));
		sort(ps);
		while (!ps.isEmpty()) {
			Point p = ps.remove(0);
			if (!visited[p.y * X + p.x]) {
				traversalChessboard(chessboard, p.y, p.x, step + 1);
			}
		}

		if (step < X * Y && !finished) {
			chessboard[row][column] = 0;
			visited[row * X + column] = false;
		} else {
			finished = true;
		}
	}

	public static ArrayList<Point> next(Point curPoint) {
		ArrayList<Point> ps = new ArrayList<Point>();
		Point p1 = new Point();
		// ��ʾ���������5���λ��
		if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y - 1) >= 0) {
			ps.add(new Point(p1));
		}
		// �ж����������6���λ��
		if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y - 2) >= 0) {
			ps.add(new Point(p1));
		}
		// �ж����������7���λ��
		if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y - 2) >= 0) {
			ps.add(new Point(p1));
		}
		// �ж����������0���λ��
		if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y - 1) >= 0) {
			ps.add(new Point(p1));
		}
		// �ж����������1���λ��
		if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y + 1) < Y) {
			ps.add(new Point(p1));
		}
		// �ж����������2���λ��
		if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y + 2) < Y) {
			ps.add(new Point(p1));
		}
		// �ж����������3���λ��
		if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y + 2) < Y) {
			ps.add(new Point(p1));
		}
		// �ж����������4���λ��
		if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y + 1) < Y) {
			ps.add(new Point(p1));
		}
		return ps;
	}
	
	public static void sort(ArrayList<Point> ps) {
		ps.sort(new Comparator<Point>() {

			@Override
			public int compare(Point arg0, Point arg1) {
				// TODO Auto-generated method stub
				int count1 = next(arg0).size();
				int count2 = next(arg1).size();
				if (count1 < count2) {
					return -1;
				}else if (count1 == count2) {
					return 0;
				}else {
					return 1;
				}
			}
			
		});
	}

}
