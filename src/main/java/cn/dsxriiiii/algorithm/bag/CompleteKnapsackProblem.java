package cn.dsxriiiii.algorithm.bag;

/**
 * @PackageName: cn.dsxriiiii.algorithm.bag
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/11/08 20:41
 * @Description: 完全背包问题
 **/
public class CompleteKnapsackProblem {
    public static int completeKnapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[] dp = new int[capacity + 1];
        for (int i = 0; i < n; i++) {
            for (int j = weights[i]; j <= capacity; j++) {
                dp[j] = Math.max(dp[j],values[i] + dp[j - weights[i]]);
            }
        }
        return dp[capacity];
    }

    public static void main(String[] args) {
        int[] weights = {1, 3, 4};
        int[] values = {15, 20, 30};
        int capacity = 4;
        int maxValue = completeKnapsack(weights, values, capacity);
        System.out.println("背包能装的最大价值为：" + maxValue);
    }
}
