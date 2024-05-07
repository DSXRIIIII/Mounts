package cn.dsxriiiii.LeetCode.LC150;

/**
 * 题目：两树之和
 * 算法：双指针
 * 思路：双指针前后两方向移动
 */
public class LC167 {
    public int[] twoSum(int[] numbers, int target) {
        int fast = numbers.length - 1;
        int slow = 0;
        while(slow < fast){
            int sum = numbers[slow] + numbers[fast];
            if(sum == target){
                return new int[]{slow + 1,fast + 1};
            }else if(sum < target){
                slow++;
            }else{
                fast--;
            }
        }
        return new int[]{-1,-1};
    }
}
