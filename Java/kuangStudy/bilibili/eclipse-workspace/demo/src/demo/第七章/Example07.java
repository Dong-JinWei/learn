package demo.µÚÆßÕÂ;
import java.util.*;

public class Example07 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add("data_1");
		list.add("data_2");
		list.add("data_3");
		System.out.println(list);
		ListIterator it = list.listIterator(list.size());
		while (it.hasPrevious()) {
			Object obj = it.previous();
			System.out.print(obj+" ");
		}

		
	}

}
