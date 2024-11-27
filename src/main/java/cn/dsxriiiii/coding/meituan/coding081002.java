package cn.dsxriiiii.coding.meituan;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @PackageName: cn.dsxriiiii.coding.meituan
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/11/23 12:39
 * @Description:
 **/
public class coding081002 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();
        while(T-- > 0) {
            long n = scanner.nextLong();
            long k = scanner.nextLong();
            long x = scanner.nextLong();
            scanner.nextLine();
            long[] arr = new long[(int)n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextLong();
            }
            scanner.nextLine();
            long[] dp = new long[(int)n + 1];
            long tar = 0;
            Set<Long> set = new HashSet<>();
            for (int i = (int)n - 1; i >= 0; i--) {
                set.add(arr[i]);
                while (set.contains(tar)){
                    tar++;
                }
                dp[i] = Math.min(dp[i + 1] + x,tar * k);
            }
            System.out.println(dp[0]);
        }
        scanner.close();
    }
}
