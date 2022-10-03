package IOStream;

import java.io.*;

public class CopyFile {
    public static void main(String[] args) throws IOException {
        FileInputStream fileReader = new FileInputStream(".\\test\\demo.png");
        File newFile = new File("demo.png");
        if (!newFile.exists()){
            newFile.createNewFile();
        }
        FileOutputStream outputStream = new FileOutputStream(newFile);

        byte[] bytes = new byte[1024];
        int len;
        while (true){
            len = fileReader.read(bytes);
            if (len <= 0){
                break;
            }
            outputStream.write(bytes, 0, len);
        }
        outputStream.close();
        fileReader.close();


    }
}
