package cn.dsxriiiii.LeetCode.LC150;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/12 13:17
 * @Email: lihh53453@hundsun.com
 * @Description:
 */
public class LC53 {
    public int maxSubArray(int[] nums) {
        int max_value = nums[0];
        int current_sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            current_sum = Math.max(current_sum,current_sum + nums[i - 1]);
            max_value = Math.max(current_sum,max_value);
        }
        return max_value;
    }
}
