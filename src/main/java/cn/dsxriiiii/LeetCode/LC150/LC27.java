package cn.dsxriiiii.LeetCode.LC150;

/**
 * @Author DSXRIIIII
 * @Project mounts
 * @Package cn.dsxriiiii.LeetCode.LC150
 * @Date 2024/8/20 9:59
 * @Description: 移除元素
 */
public class LC27 {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length;
        while(left < right){
            if(nums[left] == val){
                nums[left] = nums[right - 1];
                right--;
            }else{
                left++;
            }
        }
        return left;
    }
}
