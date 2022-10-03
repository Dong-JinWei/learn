package com.dowei.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class GreedyAlgorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String,HashSet<String>> broadcasts = new HashMap<String, HashSet<String>>();
		HashSet<String> k1 = new HashSet<String>();
		k1.add("����");
		k1.add("�Ϻ�");
		k1.add("���");
		System.out.println("k1 : " + k1);
		
		HashSet<String> k2 = new HashSet<String>();
		k2.add("����");
		k2.add("����");
		k2.add("����");
		System.out.println("k2 : " + k2);
		
		HashSet<String> k3 = new HashSet<String>();
		k3.add("�ɶ�");
		k3.add("����");
		k3.add("����");
		System.out.println("k3 : " + k3);
		
		HashSet<String> k4 = new HashSet<String>();
		k4.add("�Ϻ�");
		k4.add("���");
		System.out.println("k4 : " + k4);
		
		HashSet<String> k5 = new HashSet<String>();
		k5.add("����");
		k5.add("����");
		System.out.println("k5 : " + k5);
		
		broadcasts.put("k1", k1);
		broadcasts.put("k2", k2);
		broadcasts.put("k3", k3);
		broadcasts.put("k4", k4);
		broadcasts.put("k5", k5);

		
		HashSet<String> allAreas = new HashSet<String>();
		allAreas.addAll(k1);
		allAreas.addAll(k2);
		allAreas.addAll(k3);
		allAreas.addAll(k4);
		allAreas.addAll(k5);
		
		System.out.println(allAreas);
		ArrayList<String> selects = new ArrayList<String>();
		
		HashSet<String> tempSet = new HashSet<String>();
		
		String maxKey = null;
		
		while(allAreas.size() != 0) {
			maxKey = null;
			for(String key : broadcasts.keySet()) {
				tempSet.clear();
				HashSet<String> areas = broadcasts.get(key);
				tempSet.addAll(areas);
				tempSet.retainAll(allAreas);				
				
//				if (tempSet.size() > 0 && (maxKey == null || tempSet.size() > broadcasts.get(maxKey).size())) {
//					maxKey = key;
//				}
				
				if (tempSet.size() > 0 && maxKey == null) {
					maxKey = key;
				}else if (maxKey != null) {
					HashSet<String> tempMaxSet = broadcasts.get(maxKey);
					tempMaxSet.retainAll(allAreas);
					if (tempSet.size() > tempMaxSet.size()) {
						maxKey = key;
					}
				}
				
			}
			if (maxKey != null) {
				selects.add(maxKey);
				allAreas.removeAll(broadcasts.get(maxKey));
			}
		}
		
		System.out.println("�õ��Ľ���ǣ�" + selects);
	}

}
