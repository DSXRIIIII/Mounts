package cn.dsxriiiii.coding.meituan;

import java.util.Scanner;

/**
 * @PackageName: cn.dsxriiiii.coding.meituan
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/07 10:14
 * @Description: main
 **/
public class True24090701 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] arr = new long[n];
        long[][] dp = new long[n + 1][2];
        dp[0][0] = 0;
        dp[0][1] = 0;
        for(int i = 1; i <= n;i++){
            arr[i - 1] = scanner.nextLong();
            if(arr[i - 1] % 2 == 1){
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = dp[i - 1][1] + arr[i - 1] + 1;
            }else{
                dp[i][0] = dp[i - 1][0] + arr[i - 1] + 1;
                dp[i][1] = dp[i - 1][1];
            }
        }
        System.out.println(Math.min(dp[n][0],dp[n][1]));
    }
}
