package cn.dsxriiiii.coding.oppo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @PackageName: cn.dsxriiiii.coding.oppo
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/11/27 16:28
 * @Description:
 **/
public class coding081302 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int res = 0;
        int cur = 0;
        for (int i = 0; i < n; i++) {
            int now = cur | arr[i];
            if (now > k) {
                res++;
                cur = arr[i];
                if (cur > k){
                    System.out.println(-1);
                    return;
                }
            }else {
                cur = now;
            }
        }
        if (res >= 0){
            res++;
        }
        System.out.println(res);
        scanner.close();
    }
}
