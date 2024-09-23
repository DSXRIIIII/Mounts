package cn.dsxriiiii.newcoder;
import java.util.Scanner;

/**
 * @PackageName: cn.dsxriiiii.newcoder
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/05 16:03
 * @Description: 完成括号匹配
 **/
public class BD8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string = in.nextLine();
        char[] str = string.toCharArray();
        int count = 0;
        StringBuffer l = new StringBuffer();
        StringBuffer r = new StringBuffer();
        for (char c : str) {
            if (c == '[') {
                count++;
            } else if (c == ']') {
                count--;
            }
        }
        if (count < 0) {
            count++;
            l.append('[');
        }
        for (int i = 0; i < count; i++) {
            r.append(']');
        }
        StringBuffer append = l.append(string).append(r);
        System.out.println(append);
    }
}
