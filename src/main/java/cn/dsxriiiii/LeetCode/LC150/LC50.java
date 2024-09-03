package cn.dsxriiiii.LeetCode.LC150;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/14 9:47
 * @Email: lihh53453@hundsun.com
 * @Description: Pow(x, n)
 * 递归求平方
 * 1. 正数quickPow(x,N) 负数 1/quickPow(x,-N)
 * 2. 递归 如X**2 = X*X  X**3 = X**X**X
 */
public class LC50 {
    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickPow(x,N) : 1 / quickPow(x,-N);
    }
    public double quickPow(double x,Long N){
        if(N == 0) return 1.0;
        double y = quickPow(x,N / 2);
        return N % 2 == 0 ?  y * y : y * y * x;
    }
}
