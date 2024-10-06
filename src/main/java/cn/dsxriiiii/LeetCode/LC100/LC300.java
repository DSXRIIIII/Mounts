package cn.dsxriiiii.LeetCode.LC100;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.LC100
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/06 0:43
 * @Description:
 **/
public class LC300 {
    public int lengthOfLIS(int[] nums) {
        int res = 1;
        int[] dp = new int[nums.length + 1];
        dp[0] = 1;
        for (int i = 1; i < nums.length + 1 ; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
                res = Math.max(res,dp[i]);
            }
        }
        return res;
    }
}
