package cn.dsxriiiii.coding.dajiang;


import java.util.Arrays;
import java.util.Scanner;

/**
 * @PackageName: cn.dsxriiiii.coding.dajiang
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/11/25 16:22
 * @Description:
 **/
public class coding081101 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] MN = scanner.nextLine().split(" ");
        int m = Integer.parseInt(MN[0]);
        int n = Integer.parseInt(MN[1]);
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[m - 1][n - 1] = Math.max(1, 1 - grid[m - 1][n - 1]);
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i < m - 1) {
                    dp[i][j] = Math.min(dp[i][j],Math.max(1,dp[i + 1][j] - grid[i][j]));
                }
                if (j < n - 1) {
                    dp[i][j] = Math.min(dp[i][j],Math.max(1,dp[i][j + 1] - grid[i][j]));
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
    }
}
