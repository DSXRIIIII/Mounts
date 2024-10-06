package cn.dsxriiiii.LeetCode.LC100;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.LC100
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/01 13:32
 * @Description: LC53
 **/
public class LC53 {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int pre = 0;
        for(int num : nums){
            pre = Math.max(pre + num,num);
            max = Math.max(pre,max);
        }
        return max;
    }
}
