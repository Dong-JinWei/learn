package demo.µÚÆßÕÂ;

import java.util.ArrayList;
import java.util.Iterator;

public class Example06 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add("Jack");
		list.add("Annie");
		list.add("Rose");
		list.add("Tom");
		Iterator it = list.iterator();
		while (it.hasNext()) {
			Object obj = it.next();
			if ("Annie".equals(obj)) {
				list.remove(obj);
				break;
			}
		}
		System.out.println(list);
	}

}
