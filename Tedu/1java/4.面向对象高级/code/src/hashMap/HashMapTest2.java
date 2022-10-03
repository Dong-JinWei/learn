package hashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author 26465
 * @create 2022-02-08 15:40
 */
public class HashMapTest2 {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();

        map.put(1005, "aa");
        map.put(1006, "bb");
        map.put(1007, "cc");
        map.put(1008, "dd");

        //方法1 迭代器
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        Iterator<Map.Entry<Integer, String>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> next = iterator.next();
            Integer key = next.getKey();
            String value = next.getValue();
            System.out.println(key + " " + value);
        }
        System.out.println();
        //方法2  keySet()
        Set<Integer> set = map.keySet();
        for (Integer key : set) {
            String value = map.get(key);
            System.out.println(key + " " + value);
        }
    }
}
