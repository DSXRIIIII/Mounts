package cn.dsxriiiii.LeetCode.LC150;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/12 17:47
 * @Email: lihh53453@hundsun.com
 * @Description: 在排序数组中查找元素的第一个和最后一个位置
 * 最后一个位置：满足条件nums[mid] <= target left = mid + 1 此时走到target后一位 所以rightIndex要-1
 * 元素的第一个位置：满足条件nums[mid] >= target right = mid - 1 此时会向左走 直到走到边界
 */
public class LC34 {
    public int[] searchRange(int[] nums, int target) {
        int leftIndex = bin_search(nums,target,true);
        int rightIndex = bin_search(nums,target,false) - 1;
        //注意满足<=的条件
        if(leftIndex <= rightIndex && rightIndex < nums.length && nums[leftIndex] == target && nums[rightIndex] == target){
            return new int[]{leftIndex,rightIndex};
        }
        return new int[]{-1,-1};
    }

    private int bin_search(int[] nums, int target, boolean flag) {
        int left = 0;
        int right = nums.length - 1;
        int ans = nums.length;//int ans = nums.length;初始化为数组长度 情况分析:[1]
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > target || (flag&&(nums[mid] >= target))){
                right = mid - 1;
                ans = mid;
            }else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
