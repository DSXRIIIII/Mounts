package cn.dsxriiiii.LeetCode.LC100;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.LC100
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/04 18:38
 * @Description:
 **/
public class LC34 {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int start = -1;
        int end = -1;
        while(left <= right){
            int mid = left + (right - left) >> 1;
            if(nums[mid] < target){
                left = mid + 1;
            }
            if(nums[mid] > target){
                right = mid - 1;
            }
            if(nums[mid] == target){
                start = mid;
                right = mid - 1;
            }
        }
        left = 0;
        right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) >> 1;
            if(nums[mid] < target){
                left = mid + 1;
            }
            if(nums[mid] > target){
                right = mid - 1;
            }
            if(nums[mid] == target){
                end = mid;
                left = mid + 1;
            }
        }
        return new int[]{start,end};
    }
}
