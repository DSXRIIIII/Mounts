package cn.dsxriiiii.LeetCode.LC150;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/12 15:09
 * @Email: lihh53453@hundsun.com
 * @Description: 搜索插入位置
 */
public class LC35 {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(target == nums[mid]){
                return mid;
            }
            if(target < nums[mid]) right = mid - 1;
            if(target > nums[mid]) left = mid + 1;
        }
        return left;
    }
}
