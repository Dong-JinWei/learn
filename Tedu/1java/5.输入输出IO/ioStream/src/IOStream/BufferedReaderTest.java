package IOStream;

import java.io.*;

public class BufferedReaderTest {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("a.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        char[] chars = new char[1024];
        int read = bufferedReader.read(chars, 0, chars.length);
        System.out.println(new String(chars, 0, read));
        bufferedReader.close();
        fileReader.close();

    }
}
