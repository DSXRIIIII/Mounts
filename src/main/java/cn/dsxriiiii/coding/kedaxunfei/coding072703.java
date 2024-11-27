package cn.dsxriiiii.coding.kedaxunfei;

import java.util.Scanner;

/**
 * @PackageName: cn.dsxriiiii.coding.kedaxunfei
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/11/12 20:45
 * @Description:
 **/
public class coding072703 {
    static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // f[i][k][l]表示前i个数字，异或和为k，以l为结尾的方案数
        long[][][] f = new long[n + 1][2 * m + 1][m + 1];
        f[0][0][0] = 1;

        for (int i = 1; i <= n; i++) {
            // 前缀和数组
            long[][] pre = new long[2 * m + 1][m + 1];
            for (int t = 0; t <= 2 * m; t++) {
                for (int p = 0; p <= m; p++) {
                    pre[t][p] = f[i - 1][t][p];
                    if (p!= 0) {
                        pre[t][p] = (pre[t][p] + pre[t][p - 1]) % MOD;
                    }
                }
            }

            for (int k = 0; k <= 2 * m; k++) {
                for (int l = 0; l <= m && (k ^ l) <= 2 * m; l++) {
                    f[i][k][l] = (f[i][k][l] + pre[k ^ l][l]) % MOD;
                }
            }
        }

        long ans = 0;
        for (int i = 0; i <= m; i++) {
            ans = (ans + f[n][m][i]) % MOD;
        }

        System.out.println(ans);
    }
}
