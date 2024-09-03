package cn.dsxriiiii.LeetCode.LC150;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/13 13:25
 * @Email: lihh53453@hundsun.com
 * @Description:
 * (x >> k) & 1 获取第k位数字
 * (x << 1) | 1/0 将数字1/0添加到数字末尾
 */
public class LC190 {
    public int reverseBits(int n) {
        int temp = 0;
        for (int i = 0; i < 32; i++) {
            //1.(n&1)取n的最后一位
            //2.x<<(n) 将x左移n位
            //3.temp = (n & 1) << (31 - i) | temp 将最后一位左移的结果添加到temp的末尾 或运算
            temp |= (n & 1) << (31 - i);
            //逻辑右移 去除最后一位
            n>>>=1;
        }
        return temp;
    }
}
