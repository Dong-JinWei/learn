import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 第25题：
 * 写一个函数,它的原形是int continumax(char *outputstr,char *intputstr)
 * 功能：
 * 在字符串中找出连续最长的数字串，并把这个串的长度返回，
 * 并把这个最长数字串付给其中一个函数参数outputstr所指内存。
 * 例如："abcd12345ed125ss123456789"的首地址传给intputstr后，函数将返回9，
 * outputstr所指的值为123456789
 */
public class No_25 {
    public static void main(String[] args) {
        String str = "abcd12345ed125ss123456789";
        System.out.println(continumax(str, ""));
    }

    public static int continumax(String outputstr, String intputstr) {
        int  countMax = 0;  //统计最大的连续数字
        int indexEnd = 0;  //保存连续数字的下标
        int i, count;

        for (i = 0,count = 0; i < outputstr.length(); i++) {
            if (Character.isDigit(outputstr.charAt(i))) {  // 如果是是个数字，计数器+1
                ++count;
            }else{  // 如果不是数字
                if (count > countMax) {  // 如果当前计数器，大于最大值的计数器，那么，就将最大值计数器设置成当前计数器
                    indexEnd = i - 1;  // 并且将这个连续数组的最后一位的下标保存起来。
                    countMax = count;
                }
                count = 0; // 将count重置为0
            }
        }

        if (count >= countMax){  // 如果到了字符串的最后一位，并且count > countMax
            indexEnd = i - 1;  // 连续数字的下标设置为i
            countMax = count;
        }

        for(int j = 0; j < countMax; j++, indexEnd--){  // 因为有countMax个数字，所以循环countMax次，然后从连续数字的最后一个位置开始遍历，添加到字符串中
            intputstr = outputstr.charAt(indexEnd) + intputstr;
        }

        System.out.println(intputstr);

        return countMax;
    }
}
