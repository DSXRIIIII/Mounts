package cn.dsxriiiii.LeetCode.LC100;

import java.util.Arrays;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.LC100
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/06 0:53
 * @Description:
 **/
public class Lc152 {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int[] dp_max = new int[len];
        int[] dp_min = new int[len];
        for (int i = 0; i < nums.length ; i++) {
            dp_max[i] = nums[i];
            dp_min[i] = nums[i];
        }
        for (int i = 1; i < len ; i++) {
            dp_max[i] = Math.max(Math.max(nums[i],dp_max[i - 1] * nums[i]),dp_min[i - 1] * nums[i]);
            dp_min[i] = Math.min(Math.min(nums[i],dp_max[i - 1] * nums[i]),dp_min[i - 1] * nums[i]);
        }
        int ans = dp_max[0];
        for (int i = 1; i < len; ++i) {
            ans = Math.max(ans,dp_max[i]);
        }
        return ans;
    }
}
