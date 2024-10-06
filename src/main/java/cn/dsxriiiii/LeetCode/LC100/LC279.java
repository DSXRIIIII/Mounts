package cn.dsxriiiii.LeetCode.LC100;

import java.util.Arrays;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.LC100
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/05 18:05
 * @Description: LC279
 **/
public class LC279 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j * j <= i ; j++) {
                min = Math.min(min,dp[i - j * j]);
            }
            dp[i] = min + 1;
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}
