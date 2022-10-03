package demo.µÚÆßÕÂ;
import java.util.*;

public class Example08 {
	public static void main(String[] args) {
		Vector v = new Vector();
		v.add("Jack");
		v.add("Rose");
		v.add("Tom");
		Enumeration en = v.elements();
		while(en.hasMoreElements()) {
			Object obj = en.nextElement();
			System.out.println(obj);
		}
	}

}
