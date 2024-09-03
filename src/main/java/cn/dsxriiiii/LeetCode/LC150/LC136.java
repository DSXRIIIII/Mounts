package cn.dsxriiiii.LeetCode.LC150;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/13 14:23
 * @Email: lihh53453@hundsun.com
 * @Description: 只出现过一次的数字
 * 异或 a⊕0=a 异或0为0 异或自己为0
 * 异或的运算规则为 a⊕b⊕a = b⊕a⊕a = b⊕(a⊕a) = b⊕0 = b
 */
public class LC136 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int num:nums){
            res ^= num;
        }
        return res;
    }
}
