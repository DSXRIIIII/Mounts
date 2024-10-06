package cn.dsxriiiii.LeetCode.LC100;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.LC100
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/30 12:43
 * @Description: LC42
 **/
public class LC42 {
    public int trap(int[] height) {
        int left_max = 0,right_max = 0;
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        while(left < right){
            left_max = Math.max(left_max,height[left]);
            right_max = Math.max(right_max,height[right]);
            if(height[left] < height[right]){
                res += left_max - height[left];
                left++;
            }else{
                res += right_max - height[right--];
            }
        }
        return res;
    }
}
