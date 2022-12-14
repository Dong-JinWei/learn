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
		System.out.println("骑士周游算法，开始运行~~");
		// 测试骑士周游算法是否正确
		X = 8;
		Y = 8;
		int row = 5; // 马儿初始位置的行，从1开始编号
		int column = 1 ; // 马儿初始位置的列，从1开始编号
		int[][] chessboard = new int[X][Y];
		visited = new boolean[X * Y];// 初始值都是false
		long start = System.currentTimeMillis();
		traversalChessboard(chessboard, row - 1, column - 1, 1);
		long end = System.currentTimeMillis();
		System.out.println("共耗时: " + (end - start) + " 毫秒");

		// 输出棋盘的最后情况
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
		// 表示马儿可以走5这个位置
		if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y - 1) >= 0) {
			ps.add(new Point(p1));
		}
		// 判断马儿可以走6这个位置
		if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y - 2) >= 0) {
			ps.add(new Point(p1));
		}
		// 判断马儿可以走7这个位置
		if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y - 2) >= 0) {
			ps.add(new Point(p1));
		}
		// 判断马儿可以走0这个位置
		if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y - 1) >= 0) {
			ps.add(new Point(p1));
		}
		// 判断马儿可以走1这个位置
		if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y + 1) < Y) {
			ps.add(new Point(p1));
		}
		// 判断马儿可以走2这个位置
		if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y + 2) < Y) {
			ps.add(new Point(p1));
		}
		// 判断马儿可以走3这个位置
		if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y + 2) < Y) {
			ps.add(new Point(p1));
		}
		// 判断马儿可以走4这个位置
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
