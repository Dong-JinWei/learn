import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class NewMarkdownFile {
    public static void main(String[] args) {
        // 目录
        String dirName = "C:\\Users\\26465\\OneDrive\\桌面";

        // 文件名
        String fileName = "\\" + getDate();
        String path = dirName + fileName + ".md";
        createFile(path);
        String information = getInformation();
        boolean successful = insertInformation(information, path);
        System.out.println(successful ? "插入数据成功" : "插入数据失败！！");
        System.out.println(openFile(path));

    }

    /**
     *
     * @param fileName 文件名
     */
    public static void createFile(String fileName){
        File file = new File(fileName ,"UTF-8");

        // 如果存在，提示失败，返回false
        if (file.exists()){
            System.out.println("文件" + fileName + "已存在，创建失败！");
        }else {
            try {
                boolean ok = file.createNewFile();
                if (ok) {
                    System.out.println("创建文件成功：" + fileName);
                }else {
                    System.out.println("创建文件失败！！");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *
     * @param information 需要插入的信息
     * @return true 插入成功
     */
    public static boolean insertInformation(String information, String path){
        try {
            // 读取要写入的文件
            FileWriter writerFile = new FileWriter(path);
            // 将信息写入文件
            writerFile.write(information);
            // 刷新缓冲区
            writerFile.flush();
            // 关闭资源
            writerFile.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     *
     * @return 需要插入文档的内容
     */
    public static String getInformation(){
        String todayDate = getDate();
        return "<center>姓名：<u> 董金伟 </u>&nbsp;&nbsp;&nbsp;&nbsp;日期：<u>"+todayDate+"</u></center>";

    }

    public static String getDate(){
        // 获取日期
        Date date = new Date();
        // 格式化日期
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        // 返回格式化后的日期
        return simpleDateFormat.format(date);
    }

    public static String openFile(String path){

        try {
            Desktop.getDesktop().open(new File(path));
            return "打开成功";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "打开失败";
    }
}

