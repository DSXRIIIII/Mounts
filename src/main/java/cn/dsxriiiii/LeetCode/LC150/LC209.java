package cn.dsxriiiii.LeetCode.LC150;

/**
 * 题目：长度最小的子数组
 * 算法：滑动窗口
 * 解题思路：1.初始窗口大小为0 start end 都是从0开始
 *         2.while循环中end一直向右移动并且 当sum > target，start向右移动缩小窗口大小
 *         3.ans记录最小值
 */
public class LC209 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        System.out.println(minSubArrayLen(target,nums));
    }
    public static int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int start = 0;
        int end = 0;//end值不能设为1 否则无法添加第一个元素
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        while(end < len){
            sum += nums[end];
            while(sum >= target){
                ans = Math.min(ans,end - start + 1);
                sum-=nums[start++];
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
