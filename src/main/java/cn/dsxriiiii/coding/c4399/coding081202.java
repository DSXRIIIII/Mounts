package cn.dsxriiiii.coding.c4399;

import java.util.Arrays;

/**
 * @PackageName: cn.dsxriiiii.coding.c4399
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/11/26 17:12
 * @Description:
 **/
public class coding081202 {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(robRange(nums,0, nums.length - 2),robRange(nums,1, nums.length - 1));
    }
    public int robRange(int[] nums, int start, int end){
        int f0 = nums[start];
        int f1 = Math.max(nums[start],nums[start + 1]);
        for (int i = start + 2; i <= end ; i++) {
            int newF = Math.max(f1,f0 + nums[i - 1]);
            f0 = f1;
            f1 = newF;
        }
        return f1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,2};
        new coding081202().rob(arr);
    }
}
