package cn.dsxriiiii.LeetCode.LC150;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/13 14:09
 * @Email: lihh53453@hundsun.com
 * @Description: 位1的个数
 * (1<<i) i左移i位
 * (n & (1<<i)) n的第(1<<i)位 1/0
 * n & (n−1) 将最低为1 变为 0
 * 当n不为0时 不断将1变成0
 *
 */
public class LC191 {
    public int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i < 31; i++) {
            if((n & (1<<i)) != 0) res++;
        }
        return res;
    }
    public int hammingWeight_1(int n) {
        int res = 0;
        while(n != 0){
            n &= (n - 1);
            res++;
        }
        return res;
    }
}
