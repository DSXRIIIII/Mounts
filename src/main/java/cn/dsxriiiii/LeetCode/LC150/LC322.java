package cn.dsxriiiii.LeetCode.LC150;

import java.util.Arrays;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/15 9:28
 * @Email: lihh53453@hundsun.com
 * @Description: 零钱兑换
 * dp数组的长度为金额+1 dp[0]时金额为零时初始化为0
 * 初始化每个数组的值为amount+1
 * 遍历每一个硬币 对于每一个金额i
 * dp[i]=Math.min(dp[i],dp[i-coin]+1)
 */
public class LC322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        int max = amount + 1;
        Arrays.fill(dp,max);
        for (int i = 1; i <= amount ; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
