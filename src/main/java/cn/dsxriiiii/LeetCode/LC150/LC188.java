package cn.dsxriiiii.LeetCode.LC150;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.LC150
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/08/19 10:28
 * @Description: 买卖股票的最佳时机IV
 * 分析得出五个状态
 * 没有操作 （其实我们也可以不设置这个状态）
 * 第一次持有股票 dp[i][0 + 1] = Math.max(dp[i - 1][0 + 1],dp[i - 1][0] - prices[i]);   j = 0 = 0 * k -> 0 * k + 1  【0】
 * 第一次不持有股票 dp[i][0 + 2] = Math.max(dp[i - 1][0 + 2],dp[i - 1][0 + 1] + prices[i]); j = 0 = 0 * k  -> 0 * k + 2  【1】
 * 第二次持有股票 dp[i][0 + 3] = Math.max(dp[i - 1][0 + 3],dp[i - 1][0 + 2] - prices[i]);  j = 1 = 1 * k -> 1 * k + 1  【2】
 * 第二次不持有股票 dp[i][0 + 4] = Math.max(dp[i - 1][0 + 4],dp[i - 1][0 + 3] - prices[i]);  j = 1 = 1 * k -> 1 * k + 2  【3】
 * ....类推得到递推公式
 **/
public class LC188 {
    public int maxProfit(int k, int[] prices) {
        int l = prices.length;
        int[][] dp = new int[l][2*k+2];
        for (int i = 1; i < 2 * k; i+=2) {
            dp[0][i] = -prices[0];
        }
        for (int i = 1; i < l; i++) {
            for (int j = 0; j < 2 * k - 1 ; j+=2) {
//                //dp[i][j] = dp[i - 1][j];  对应1
//                dp[i][j + 1] = Math.max(dp[i - 1][j + 1],dp[i - 1][j] - prices[j]);   //对应 情况1 情况3
//                dp[i][j + 2] = Math.max(dp[i - 1][j + 2],dp[i - 1][j + 1] + prices[j]);  //对应  情况2  情况4

                //dp[i][j] = dp[i - 1][j];  对应1
                dp[i][j + 1] = Math.max(dp[i - 1][j + 1],dp[i - 1][j] - prices[i]);   //对应 情况1 情况3
                dp[i][j + 2] = Math.max(dp[i - 1][j + 2],dp[i - 1][j + 1] + prices[i]);  //对应  情况2  情况4
            }
        }
//        return dp[l - 1][2 * k + 1];
        return dp[l - 1][2 * k];
    }
}
