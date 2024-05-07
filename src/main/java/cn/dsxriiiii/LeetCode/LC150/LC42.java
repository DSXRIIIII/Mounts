package cn.dsxriiiii.LeetCode.LC150;

/**
 * 题目：接雨水
 * 算法思路：双指针
 * 具体思路：1.维护左右leftMax,rightMax记录左右的最大值
 *         2.如果 height[left] < height[right],则必有leftMax < rightMax或者leftMax > rightMax那么此时就可能会有雨水
 *         3.雨水值就为leftMax - height[left] 或者 rightMax - height[right]
 *         4.最后res用来保存雨水值 当左右left与right指针相遇时结束
 */
public class LC42 {
    public int trap(int[] height) {
        int res = 0;
        int left = 0,right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        while(left < right){
            leftMax = Math.max(height[left],leftMax);
            rightMax = Math.max(height[right],rightMax);
            if(height[left] < height[right]){
                res+=leftMax - height[left];
                left++;
            }else{
                res+=rightMax - height[right];
                right--;
            }
        }
        return res;
    }
}
