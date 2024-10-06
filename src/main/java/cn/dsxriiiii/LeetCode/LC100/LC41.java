package cn.dsxriiiii.LeetCode.LC100;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.LC100
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/01 14:26
 * @Description: LC41
 **/
public class LC41 {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if(nums[i] < 0){
                nums[i] = len + 1;
            }
        }
        for (int i = 0; i < len; i++) {
            if(nums[i] <= len){
                int num = nums[i];
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < len; i++) {
            if(nums[i] > 0){
                return nums[i];
            }
        }
        return len + 1;
    }
}
