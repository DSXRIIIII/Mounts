package cn.dsxriiiii.PowerPointOffer.dynamic_Programming;

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        MinCostClimbingStairs minCostClimbingStairs = new MinCostClimbingStairs();
        int[] cost = {1,100,1,100,1,1};
    }
    public int CostClimbingStairs_n(int[] cost){
        int len = cost.length;
        int[] dp = new int[len];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i = 2;i < len;i++){
            dp[i] = Math.min(dp[i - 1],dp[i - 2]) + cost[i];
        }
        return Math.min(dp[len - 2],dp[len - 1]);
    }
    public int CostClimbingStairs_1(int[] cost){
        int len = cost.length;
        int[] dp = new int[]{cost[0],cost[1]};
        for (int i = 2; i < cost.length ; i++) {
            dp[i%2] = Math.min(dp[0],dp[1]) + cost[i];
        }
        return Math.min(dp[len - 2],dp[len - 1]);
    }
}
