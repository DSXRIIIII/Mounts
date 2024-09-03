package cn.dsxriiiii.LeetCode.LC150;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/13 17:00
 * @Email: lihh53453@hundsun.com
 * @Description: 阶乘后的零
 * 即找五的个数 10就是2 * 5 但是在阶乘中5的数量少于2 多少个0就取决于多少个5
 * 1 * 2 * 3 * 4 * 5 * 7 * 8 * 9 * 10
 * 5的倍数个数为2 -> 10/5=2
 * 对于阶乘 100
 * 5的倍数个数为  -> 100/5=20
 * 5 * 5 的倍数个数为 100/5*5=44 25 50 75 100 四个 以此类推
 */
public class LC172 {
    public int trailingZeroes(int n) {
        int ans = 0;
        while(n != 0){
            n /= 5;
            ans += n;
        }
        return ans;
    }
}
