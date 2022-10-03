import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution43 {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        LinkedList<Integer> demo = new LinkedList<>();
        demo.add(1);
        demo.add(2);
        demo.add(3);
        demo.add(4);
        System.out.println(demo);
        list.add(demo);
        list.add(new LinkedList<>(demo));
        System.out.println(list);


        LinkedList<Integer> demo2= new LinkedList<>();
        demo2.add(6);
        demo2.add(7);
        demo2.add(8);
        demo2.add(9);
        list.add(demo2);
        System.out.println(list);

    }
}
