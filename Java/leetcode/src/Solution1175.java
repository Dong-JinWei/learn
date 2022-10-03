import java.util.ArrayList;
import java.util.List;

public class Solution1175 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= 100; i++){
            boolean ok = true;
            for(int j  = 2; j * j <= i; j++){
                if (i % j == 0) ok = false;
            }
            if (ok) list.add(i);
        }
        int  l = 0, r = list.size() - 1;
        int mid = l + r + 1 >> 1;
        System.out.println(list);
        System.out.println(r);
        System.out.println(mid);

    }
}
