package cn.dsxriiiii.LeetCode.LC100;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.LC100
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/04 18:11
 * @Description: LC35
 **/
public class LC35 {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        int mid = left + (right - left) / 2;
        while(left <= right){
            if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = right - 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
