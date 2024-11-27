package cn.dsxriiiii.coding.oppo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @PackageName: cn.dsxriiiii.coding.oppo
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/11/27 16:11
 * @Description:
 **/
public class coding081301 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }

        int cur = 0;
        int res = 1;
        for (int i = 1; i <= n; i++) {
            if (a[i] == 1) {
                res = Math.max(res, i - cur);
                cur = i;
            }
        }

        if (cur != n) {
            res = Math.max(res, n - cur + 1);
        }

        System.out.println(res);

        sc.close();
    }
}
