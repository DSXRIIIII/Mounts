package cn.dsxriiiii.LeetCode.LC100;

import java.util.Arrays;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.LC100
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/05 17:48
 * @Description: LC198
 **/
public class LC198 {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int[] dp = new int[nums.length + 1];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < nums.length ; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i],dp[i - 1]);
        }
        System.out.println(Arrays.toString(dp));
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        LC198 lc198 = new LC198();
        lc198.rob(new int[]{1,2,3,1});
    }
}
