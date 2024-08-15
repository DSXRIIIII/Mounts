package cn.dsxriiiii.LeetCode.LC150;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/14 9:26
 * @Email: lihh53453@hundsun.com
 * @Description: x 的平方根
 * 二分法
 */
public class LC69 {
    public int mySqrt(int x) {
        if(x == 1) return 1;
        if(x == 0) return 0;
        int left = 1;
        int right = x / 2;
        while(left <= right){
            int mid = left + (right - left + 1)/2;
            if(mid > x / mid){
                right = mid - 1;
            }else if(mid == x / mid){
                return mid;
            }else{
                left = left + 1;
            }
        }
        return left + 1;
    }
}
