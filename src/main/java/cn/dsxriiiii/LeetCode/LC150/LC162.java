package cn.dsxriiiii.LeetCode.LC150;


/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/12 16:15
 * @Email: lihh53453@hundsun.com
 * @Description: 寻找峰值
 * 1.直接找最大值 最大值就是峰值
 * 2.时间复杂度为log(n) 使用二分查找
 * 判断如果mid此时位于下坡路 那么此时可能找不到峰值
 * 如果mid走上坡路 那么一定有峰值
 */
public class LC162 {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid + 1] < nums[mid]){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}
