package cn.dsxriiiii.LeetCode.LC100;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.LC100
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/06 13:39
 * @Description:
 **/
public class LC416 {
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        int sum = 0;
        int max_num = 0;
        for(int num : nums){
            sum += num;
            max_num = Math.max(max_num,num);
        }
        int target = sum / 2;
        if(sum % 2 == 1) return false;
        if(target < max_num){
            return false;
        }
        boolean[][] dp = new boolean[len][target + 1];
        for (int i = 0; i < len; i++) {
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;
        for (int i = 1; i < len; i++) {
            int num = nums[i];
            for (int j = 1; j < target + 1; j++) {
                if(j >= num){
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - num];
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[len - 1][target];
    }
}
