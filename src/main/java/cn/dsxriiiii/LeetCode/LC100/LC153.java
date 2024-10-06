package cn.dsxriiiii.LeetCode.LC100;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.LC100
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/05 13:33
 * @Description: LC153
 **/
public class LC153 {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(nums[mid] < nums[high]){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return nums[low];
    }
}
