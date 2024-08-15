package cn.dsxriiiii.LeetCode.LC150;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/12 14:27
 * @Email: lihh53453@hundsun.com
 * @Description: 环形子数组的最大和
 * 考虑到数组是环形的 从最开头的几个节点和尾节点也可能创造最大的res
 * 1.先记录从前往后遍历的最大和res 即最大的子序列和
 * 2.记录左遍历的对于每一个节点的最大的前缀和
 * 3.从右向左遍历 记录右边开始的后缀和 res=Math.max(res,后缀和right_sum+最大前缀和)
 */
public class LC918 {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int[] leftMax = new int[n];
        leftMax[0] = nums[0];
        int pre = nums[0];
        int res = nums[0];
        int left_sum = nums[0];
        for (int i = 1; i < n ; i++) {
            pre = Math.max(pre+nums[i],nums[i]);
            res = Math.max(pre,res);//记录前缀和 保存最大的子序列的和
            left_sum+=nums[i];
            leftMax[i] = Math.max(leftMax[i - 1],left_sum);//记录前缀最大值
        }
        int right_sum = 0;
        for (int i = n - 1; i > 0; i--) {
            right_sum += nums[i];
            //从后往前遍历 前缀最大值+右边和与最大的子序列的和比较的到最大和
            res = Math.max(leftMax[i - 1] + right_sum,res);
        }
        return res;
    }
}
