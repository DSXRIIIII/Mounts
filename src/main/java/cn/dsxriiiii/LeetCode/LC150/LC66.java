package cn.dsxriiiii.LeetCode.LC150;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/13 16:47
 * @Email: lihh53453@hundsun.com
 * @Description: 加一
 * 如果没有满足进位的条件 digit[i]++ 后直接返回即可
 * 如果有进位 989 在第二次循环时 会以 990的情况返回
 * 如果 999 全部都进位了 创建新数组 第一位为1 其余位未被初始化都是0 直接返回即可
 */
public class LC66 {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0 ; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if(digits[i] != 0) return digits;
        }
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }
}
