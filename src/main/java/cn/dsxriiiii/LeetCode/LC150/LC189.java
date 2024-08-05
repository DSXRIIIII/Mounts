package cn.dsxriiiii.LeetCode.LC150;

import java.util.Arrays;

/**
 * @ProjectName: Mounts
 * @Description:
 * @Author: DSXRIIIII
 * @CreateDate: 2024/6/18 13:33
 * @Email: lihh53453@hundsun.com
 */
public class LC189 {
    public static void rotate(int[] nums,int k){
        int len = nums.length;
        int[] arr = new int[len];
        for(int i = 0; i < len;i++){
            arr[(i + k)%len] = nums[i];
            //使用取余操作进行覆盖
        }
        System.out.println(Arrays.toString(arr));
        System.arraycopy(arr,0,nums,0,len);
        //调用拷贝函数 将新数组数据拷贝到旧数组
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7};
        rotate(arr,3);
    }
}
