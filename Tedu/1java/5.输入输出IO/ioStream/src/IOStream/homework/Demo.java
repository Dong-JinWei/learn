package IOStream.homework;

import java.util.UUID;

public class Demo {
    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        String u = uuid.toString();
        u = u.replace("-", "");
        System.out.println(u);
    }
}
