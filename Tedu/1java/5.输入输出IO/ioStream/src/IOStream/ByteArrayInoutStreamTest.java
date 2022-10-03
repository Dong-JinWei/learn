package IOStream;

import java.io.ByteArrayInputStream;

public class ByteArrayInoutStreamTest {
    public static void main(String[] args) {
        byte[] buffer = "你好吗？abc".getBytes();

        ByteArrayInputStream stream = new ByteArrayInputStream(buffer);

        byte[] bytes = new byte[1024];

        int read = stream.read(bytes, 0, bytes.length);
        String s = new String(bytes, 0, read);
        System.out.println(s);
    }
}
