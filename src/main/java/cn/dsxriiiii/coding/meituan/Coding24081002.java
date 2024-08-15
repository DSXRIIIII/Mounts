package cn.dsxriiiii.coding.meituan;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/10 15:24
 * @Email: lihh53453@hundsun.com
 * @Description: 小美的数组删除
 * 题目描述：一个长度为n的数组 小妹要对数组进行操作
 * 1.删除第一个元素 数组长度-1 花费为x
 * 2.全部删除 删除代价为k*数组A中从未出现的最小非负整数 0 1 2 4 -> 3
 * 求删除数组的最小代价
 * 解决：
 * 数据逻辑：删除n个元素后删除整个数组的代码及为 n * x + k * 数组A中从未出现的最小非负整数（MEX）
 * 动态规划逻辑：从后向前遍历
 * 1.从最后的元素开始思考 因为 删除最后的元素 代表 需要花费的代价为 n * x; 此时MEX为0
 * 2.如何找到MEX
 *              2.1 从后向前遍历 MEX初始为0 如果存在一个元素i 那么MEX就为i+1
 *              2.2 多个数据循环遍历获得最新MEX
 *              while(set.containsKey(MEX)){
 *                  MEX++;
 *              }
 * 3.动态规划公式 dp[n] = Math.min(dp[n + 1] + x,k * MEX)
 * 从k * MEX 和 上个最小开销+花费x取最小值
 */
public class Coding24081002 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while(T-->0){
            long n = scanner.nextLong();
            long k = scanner.nextLong();
            long x = scanner.nextLong();
            long[] A = new long[(int)n];
            for (int i = 0; i < A.length; i++) {
                A[i] = scanner.nextLong();
            }
            long[] dp = new long[(int)(n + 1)];
            long MEX = 0;
            Set<Long> visit = new HashSet<>();
            Arrays.fill(dp,Long.MAX_VALUE);
            dp[(int)n] = 0;
            for (int i = (int)n - 1; i >= 0 ; i--) {
                visit.add(A[i]);
                while(visit.contains(MEX)){
                    MEX++;
                }
                dp[i] = Math.min(dp[i + 1] + x,k * MEX);
            }
            System.out.println(dp[0]);
        }
    }
}
