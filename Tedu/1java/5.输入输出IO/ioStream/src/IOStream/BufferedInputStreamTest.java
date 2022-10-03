package IOStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class BufferedInputStreamTest {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("a.txt");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

        byte[] bytes = new byte[1024];
        int read = bufferedInputStream.read(bytes);
        System.out.println(new String(bytes, 0, read));
        bufferedInputStream.close();
        fileInputStream.close();


    }
}
