package cn.dsxriiiii.LeetCode.LC150;

public class LC70 {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(climbStairs(n));
    }
    public static int climbStairs(int n) {
        if(n < 3) return n;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i < n;i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }
}
