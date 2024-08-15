package cn.dsxriiiii.LeetCode.LC150;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/13 14:40
 * @Email: lihh53453@hundsun.com
 * @Description: 只出现一次的数字 II
 * 和只出现一次的数字一样 但是有一个数学的推导
 * 异或的本质是做了比特位上做了模2的加法
 * 所以此题采用比特位上做模3的加法
 * 每一位数字mod三之后拼接即为只出现一次的数字
 */
public class LC137 {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int i = 0;i < 32;i++){
            int temp = 0;
            for(int num:nums){
                temp += (num>>i) & 1;
                //(num>>i) & 1 取出第i位数字 temp保存
            }
            ans |= temp % 3 << i;
            //temp % 3 取模 并且左移
            //左移结果 通过|=相加保存
            //001 | 110 -> 111
        }
        return ans;
    }
}
