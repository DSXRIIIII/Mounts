package cn.dsxriiiii.LeetCode.codetop;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.codetop
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/11/19 17:45
 * @Description:
 **/
public class LC41 {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < nums.length; i++) {
            while(nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]){
                int temp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[nums[i] - 1] = temp;
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1){
                return i + 1;
            }
        }
        return len + 1;
    }
}
