package cn.dsxriiiii.LeetCode.LC150;

/**
 * @ProjectName: Mounts
 * @Description:
 * @Author: DSXRIIIII
 * @CreateDate: 2024/6/18 13:36
 * @Email: lihh53453@hundsun.com
 */
public class LC121 {
    public int maxProfit(int[] nums){
        int minValue = Integer.MAX_VALUE;
        int maxValue = 0;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] < minValue){
                minValue = nums[i];//保存最小值
            }else{
                if(nums[i] - minValue > maxValue){
                    maxValue = nums[i] - minValue;//计算差值
                }
            }
        }
        return maxValue;
    }
}
