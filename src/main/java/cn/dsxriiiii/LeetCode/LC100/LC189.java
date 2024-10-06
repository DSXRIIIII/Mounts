package cn.dsxriiiii.LeetCode.LC100;

import java.util.Arrays;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.LC100
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/01 13:50
 * @Description: LC189
 **/
public class LC189 {
    public void rotate(int[] nums, int k) {
        int[] ints = new int[nums.length];
        for(int i = 0; i < nums.length;i++){
            ints[i] = nums[(i + k) % nums.length];
            //ints[(i + k) % nums.length] = nums[i];
        }
        System.arraycopy(ints, 0, nums, 0, nums.length);
    }
}
