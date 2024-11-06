package cn.dsxriiiii.newcoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @PackageName: cn.dsxriiiii.newcoder
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/24 16:02
 * @Description:
 **/
public class BMN3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        int m = Integer.parseInt(s[0]);
        int n = Integer.parseInt(s[1]);
        int num = Integer.parseInt(s[2]);
        int[] arr = new int[n + 1];
        while(num-->0){
            String[] indexes = scanner.nextLine().split(" ");
            int a = Integer.parseInt(indexes[0]) - 1;
            int b = Integer.parseInt(indexes[1]) - 1;
            if(a > arr[b]){
                arr[b]++;
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i > arr[j]) {
                    System.out.print('*');
                } else {
                    System.out.print('.');
                }
            }
            System.out.println();
        }
    }
}
