package cn.dsxriiiii.LeetCode.LC100;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.LC100
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/05 16:56
 * @Description: LC55
 **/
public class LC55 {
    public boolean canJump(int[] nums) {
        int max_index = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if(i <= max_index){
                max_index = Math.max(max_index,i + nums[i]);
                if (max_index >= n - 1) return true;
            }
        }
        return false;
    }
}
