package snake;

import javax.swing.*;
import java.net.URL;

//数据中心
public class Data {
    public static URL headerURL = Data.class.getResource("statics/header.png");
    public static ImageIcon header = new ImageIcon(headerURL);

    public static URL upURL = Data.class.getResource("statics/up.png");
    public static URL downURL = Data.class.getResource("statics/down.png");
    public static URL leftURL = Data.class.getResource("statics/left.png");
    public static URL rightURL = Data.class.getResource("statics/right.png");
    public static ImageIcon up = new ImageIcon(upURL);
    public static ImageIcon down = new ImageIcon(downURL);
    public static ImageIcon left = new ImageIcon(leftURL);
    public static ImageIcon right = new ImageIcon(rightURL);

    public static URL bodytURL = Data.class.getResource("statics/body.png");
    public static ImageIcon body = new ImageIcon(bodytURL);

    public static URL foodtURL = Data.class.getResource("statics/food.png");
    public static ImageIcon food = new ImageIcon(foodtURL);


}
