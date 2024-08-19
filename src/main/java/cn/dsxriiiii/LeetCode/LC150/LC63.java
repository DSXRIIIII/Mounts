package cn.dsxriiiii.LeetCode.LC150;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.LC150
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/08/17 10:17
 * @Description: 最小路径和II
 * 空间优化：
 * dp[j] = dp[j] + dp[j - 1];
 * dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
 * 因为一维dp已经保存了上一行处理的节点
 * 当前节点取决于行前一个以及行上一个 将空间优化成一维
 **/
public class LC63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid[0].length;
        int[] dp = new int[m];
        dp[0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int[] ints : obstacleGrid) {
            for (int j = 0; j < m; j++) {
                if (ints[j] == 1) {
                    dp[j] = 0;
                } else if (ints[j] == 0 && j - 1 >= 0) {
                    dp[j] = dp[j] + dp[j - 1];
                }
            }
        }
        return dp[m - 1];
    }
}
