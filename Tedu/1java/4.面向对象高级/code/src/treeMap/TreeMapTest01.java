package treeMap;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class TreeMapTest01 {
    public static void main(String[] args) {
        TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>();

        treeMap.put(6, "ff");
        treeMap.put(5, "ee");
        treeMap.put(4, "dd");
        treeMap.put(3, "cc");
        treeMap.put(2, "bb");
        treeMap.put(1, "aa");
        System.out.println(treeMap);

        Map.Entry<Integer, String> entry = treeMap.ceilingEntry(1);
        System.out.println(entry);

        entry = treeMap.higherEntry(5);
        System.out.println(entry);

        entry = treeMap.firstEntry();
        System.out.println(entry);

        treeMap.pollLastEntry();
        System.out.println(treeMap);

        treeMap.pollFirstEntry();
        System.out.println(treeMap);

        SortedMap<Integer, String> subMap = treeMap.subMap(3, 5);
        System.out.println(subMap);

        SortedMap<Integer, String> tailMap = treeMap.tailMap(4);
        System.out.println(tailMap);

        boolean b = treeMap.containsKey(4);
        System.out.println(b);
    }
}
