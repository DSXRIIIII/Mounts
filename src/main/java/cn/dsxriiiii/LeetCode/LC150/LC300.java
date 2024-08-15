package cn.dsxriiiii.LeetCode.LC150;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/15 10:00
 * @Email: lihh53453@hundsun.com
 * @Description: 最长递增子序列
 * 1.遍历i的位置 循环访问[j,i)区间
 * 2.如果dp[i]>dp[j] 说明此时满足严格递增区间
 * 递增序列：dp[i] = Math.max(dp[i],dp[j]+1);
 * maxans用来保存最大的数
 */
public class LC300 {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }
}
