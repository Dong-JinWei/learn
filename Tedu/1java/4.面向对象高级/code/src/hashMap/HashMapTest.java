package hashMap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

/**
 *
 */
public class HashMapTest {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();

        map.put(1005, "aa");
        map.put(1006, "bb");
        map.put(1007, "cc");
        map.put(1008, "dd");
        System.out.println("map1: " + map);

        HashMap<Integer, String> map1 = new HashMap<>();
        map1.putAll(map);
        System.out.println("map1: " + map1);
        System.out.println(map.size());
        Collection<String> values = map.values();
        System.out.println(values);
        Set<Integer> integers = map.keySet();
        System.out.println(integers);
        System.out.println(map.get(1005));
        map.remove(1005);
        System.out.println(map);
        map.replace(1008, "ee");
        System.out.println(map);
        map.clear();
        System.out.println(map);
        System.out.println(map.isEmpty());


    }
}
