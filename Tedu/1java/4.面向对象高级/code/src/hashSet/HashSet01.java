package hashSet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class HashSet01 {

    public static void show(HashSet<?> set){
        Iterator<?> iterator = set.iterator();
        while (iterator.hasNext()){
            Object next = iterator.next();
            System.out.print(next + " ");
        }
    }

    public static void show02(HashSet<?> set){
        for( Object obj : set){
            System.out.print(obj + " ");
        }
    }

    public static void main(String[] args){
        HashSet<String> set = new HashSet<>();
        set.add("aa");
        set.add("bb");
        set.add("cc");
        set.add("dd");
        set.add("ee");
        set.add("ff");
        show(set);
        System.out.println();
        show02(set);
        System.out.println();
        ArrayList<String> list = new ArrayList<String>();
        list.add("bb");
        list.add("ee");
        list.add("ff");
        System.out.println(set.containsAll(list));
    }
}
