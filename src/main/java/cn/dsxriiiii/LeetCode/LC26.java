package cn.dsxriiiii.LeetCode;

/**
 * @Author DSXRIIIII
 * @Project mounts
 * @Package cn.dsxriiiii.LeetCode
 * @Date 2024/8/20 10:08
 * @Description: 删除有序数组的重复项
 * 快指针匹配相等时会往后一直匹配 当匹配不相同的时候会将快指针的值给慢指针
 */
public class LC26 {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        int slow = 1;
        int fast = 1;
        while(fast!=len){
            if(nums[fast] != nums[fast-1]){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
