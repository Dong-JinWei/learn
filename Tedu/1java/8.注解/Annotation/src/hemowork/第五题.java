package hemowork;

public class 第五题 {
    public static void main(String[] args) {
        int pencil, ballpointPen, pen;

        for(pen = 0; pen <= 20; pen++){
            for(ballpointPen = 0; ballpointPen <= 50; ballpointPen++){
                for(pencil = 0; pencil <= 200; pencil++){
                    if (pen * 5 + ballpointPen * 2 + pencil * 0.5 == 100){
                        System.out.println("铅笔" + pencil + "个，圆珠笔" + ballpointPen + "个，钢笔" + pen);
                    }
                }
            }
        }
    }
}
