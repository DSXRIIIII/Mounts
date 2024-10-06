package cn.dsxriiiii.LeetCode.LC100;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.LC100
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/30 11:10
 * @Description: LC11
 **/
public class LC11 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        while(left != right){
            if(height[left] > height[right]){
                right = right - 1;
                int area = (right - left) * height[right];
                res = Math.max(area,res);
            }else{
                left = left + 1;
                int area  = (right - left) * height[left];
                res = Math.max(area,res);
            }
        }
        return res;
    }
}
