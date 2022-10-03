package IOStream;

import java.io.*;

public class BufferedWriterTest {
    public static void main(String[] args) throws IOException {
        FileWriter fileReader = new FileWriter("a.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileReader);

        char[] chars = "你好世界！".toCharArray();
        bufferedWriter.write(chars, 0, chars.length);

        bufferedWriter.close();
        fileReader.close();
    }
}
