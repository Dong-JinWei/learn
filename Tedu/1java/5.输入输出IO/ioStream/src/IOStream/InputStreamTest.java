package IOStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class InputStreamTest {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(".\\test\\a.txt");
        byte[] bytes = new byte[1024];
        //inputStream.skip(6);
        int read = inputStream.read(bytes);
        String s = new String(bytes, 0, read);
        System.out.println(s);
        inputStream.close();

    }
}
