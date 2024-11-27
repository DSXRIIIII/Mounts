package cn.dsxriiiii.coding.mihayou;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @PackageName: cn.dsxriiiii.coding.mihayou
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/11/22 11:57
 * @Description:
 **/
public class coding080301 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextLong();
        }
        scanner.nextLine();
        scanner.close();
        long res = -1;
        for (int i = 0; i < n - 1; i++) {
            res = Math.max(res,arr[i] * arr[i + 1]);
        }
        for (int i = 0; i < n; i++) {
            long left = i > n - 2 ? arr[i - 1] * arr[i + 1] : 0;
            long right = i > n - 2 ? arr[i + 1] * arr[i + 2] : 0;
            res = Math.max(res,Math.max(left, right));
        }
        System.out.println(res);
    }
}
