package cn.dsxriiiii.LeetCode.LC100;
/**
* @PackageName: cn.dsxriiiii.LeetCode.LC100
* @Author: DSXRIIIII
* @Email: 1870066109@qq.com
* @Date: Created in  2024/10/05 13:06
* @Description: LC33
**/
public class LC33 {
    public int search(int[] nums, int target) {
        if(nums.length == 0) return -1;
        if(nums.length == 1){
            return nums[0] == target ? 0 : -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(target == nums[mid]) return mid;
            if(nums[0] < nums[mid]){
                if(nums[0] <= target && target <= nums[mid]){
                    right = mid - 1;
                }else{
                    left = left + 1;
                }
            }else{
                if(nums[mid] <= target && target <= nums[nums.length - 1]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LC33 lc33 = new LC33();
        lc33.search(new int[]{1,3},0);
    }
}
