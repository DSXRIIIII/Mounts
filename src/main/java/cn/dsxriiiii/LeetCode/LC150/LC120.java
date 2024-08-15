package cn.dsxriiiii.LeetCode.LC150;

import java.util.List;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/15 10:30
 * @Email: lihh53453@hundsun.com
 * @Description: 三角形最小路径和
 * 自底向上动态规划 对于(i,j)位置来说 取(i+1,j+1)和(i+1,j) 斜对角和同列
 * 
 */
public class LC120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n+1][n+1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                dp[i][j] = Math.min(dp[i+1][j+1],dp[i+1][j])+triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }
}
