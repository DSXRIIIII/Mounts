package cn.dsxriiiii.LeetCode.LC150;

/**
 * 题目：除自身以外数组的乘积
 * 算法思路：遍历
 * 具体思路：观察测试用例发现结果数组 保存的是除本身之外的左右所有值的乘积
 * 分为两次循环更新数组
 */
public class LC238 {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] answer = new int[len];
        answer[0] = 1;
        for(int i = 1; i < len;i++){
            answer[i] = nums[i - 1] * answer[i - 1];
            //对于数组 从左往右遍历 answer保存当前坐标（不包括自己）的所有乘积
        }
        int right = 1;
        for(int i = len - 1;i >= 0;i--){
            answer[i] = answer[i] * right;
            //对于数组从右往左遍历 answer更新 right保存当前坐标（不包括当前坐标的值所有乘积
            right = right * nums[i]; //right实时更新
        }
        return answer;
    }
}
