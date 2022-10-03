package IOStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class OutputStreamTest {
    public static void main(String[] args) throws IOException {
        FileOutputStream outputStream = new FileOutputStream(".\\test\\a.txt");
        String str = "你好吗？";
        byte[] b = str.getBytes();
        outputStream.write(b);
        outputStream.close();
    }
}
