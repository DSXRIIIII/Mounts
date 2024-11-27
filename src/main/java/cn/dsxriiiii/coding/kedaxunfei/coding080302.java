package cn.dsxriiiii.coding.kedaxunfei;

import java.util.Scanner;

/**
 * @PackageName: cn.dsxriiiii.coding.kedaxunfei
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/11/19 16:30
 * @Description:
 **/
public class coding080302 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        while(n-->0){
            String[] s = scanner.nextLine().split(":");
            int h = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int cur_min = h * 60 + m;
            cur_min = cur_min - 8 * 60;
            if (cur_min < 0){
                cur_min = cur_min + 24 * 60;
            }
            int c_h = cur_min / 60;
            int c_m = cur_min % 60;
            System.out.printf("%02d:%02d\n",c_h,c_m);
        }
    }
}
