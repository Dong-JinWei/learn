/*
ʹ��switch case �����Ƿ񼰸�
*/

public class SwitchCaseTest{
    public static void main(String[] args){
        int score = 88;
        int n = score / 10;
        switch (n){
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                System.out.println("������");
                break;
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                System.out.println("����");
                break;
        }

        int m = score / 60;

        switch (m){
            case 0:
                System.out.println("������");
                break;
            case 1:
                System.out.println("����");
                break;
        }

        int season = 12;

        switch (season){
            case 3:
            case 4:
            case 5:
                System.out.println("����");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("����");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("����");
                break;
            case 12:
            case 1:
            case 2:
                System.out.println("����");
                break;
        }
    }
}