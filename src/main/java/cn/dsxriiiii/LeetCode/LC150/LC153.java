package cn.dsxriiiii.LeetCode.LC150;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/13 9:43
 * @Email: lihh53453@hundsun.com
 * @Description: 寻找旋转排序数组中的最小值
 * 将中间值与最后一个元素比较
 * 1.nums[mid] < nums[nums.length - 1] 说明中间值在第二段数组 并且最小值在mid的左边
 * 2，nums[mid] >= nums[nums.length - 1] 说明中间值在第一段数组 最小值在第二段数组 更新left = mid + 1;
 * 3.right初始化为 nums.length - 2 因为不断要和nums[n-1]比较 假如nums[n-1]为最小值 left=mid+1 也会走到target
 */
public class LC153 {
    public int findMin_1(int[] nums) {
        int left = 0;
        int right = nums.length - 2;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < nums[nums.length - 1]){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return nums[left];
    }
}
