package cn.dsxriiiii.algorithm.bag;

/**
 * @PackageName: cn.dsxriiiii.algorithm.bag
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/11/08 20:27
 * @Description: 0-1 背包问题
 * 0 - 1 背包问题是一种组合优化的 NP 完全问题。
 * 在这个问题中，有一个给定容量的背包和一组具有不同重量和价值的物品。目标是在不超过背包容量的前提下，选择一些物品放入背包，使得背包中物品的总价值最大。
 * 正如你所说，对于每个物品，只能选择放入背包（消费一次）或者不放入背包，不能将一个物品分割部分放入背包
 *
 **/
public class KnapsackProblem {
    public static void main(String[] args) {
        int[] weights = {2, 3, 4, 5};
        int[] values = {3, 4, 5, 6};
        int capacity = 8;
        int maxValue = knapsack(weights, values, capacity);
        System.out.println("背包能装的最大价值为：" + maxValue);
    }
    public static int knapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[][] dp = new int[values.length + 1][weights.length + 1];
        //注意i从1开始
        for (int i = 1; i < values.length; i++) {
            for (int j = 1; j < weights.length; j++) {
                if(weights[i - 1] > j){
                    dp[i][j] = dp[i - 1][j];
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j],values[i - 1] + dp[i - 1][j - weights[i]]);
                }
            }
        }
        return dp[n][capacity];

    }
}
