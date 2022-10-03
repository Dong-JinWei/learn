package IOStream;

import java.io.ByteArrayOutputStream;

public class ByteArrayOutputStreamTest {
    public static void main(String[] args) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] bytes = "一二三四五六七八九十一二三四五六七八九".getBytes();
        outputStream.write(bytes, 0, bytes.length);

        byte[] buffer = outputStream.toByteArray();
        String s = new String(buffer, 0, buffer.length);
        System.out.println(s);

    }
}
