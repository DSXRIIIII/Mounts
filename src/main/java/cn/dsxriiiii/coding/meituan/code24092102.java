package cn.dsxriiiii.coding.meituan;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @PackageName: cn.dsxriiiii.coding.meituan
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/21 10:59
 * @Description: 2
 **/

/**
 * 输入
 * 3 3
 * 1 2 1
 * 5 4 3
 * -1 2 -100
 * 输出
 * 6
 */
public class code24092102 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        boolean[] used = new boolean[n + 1];
        Map<Integer,Integer> map = new HashMap<>();
        int[] target = new int[n];
        int[] value = new int[n];
        int[] no_value = new int[n];
        for(int i = 0;i < n;i++){
            target[i] = scanner.nextInt();
        }
        for(int i = 0;i < n;i++){
            value[i] = scanner.nextInt();
        }
        for(int i = 0;i < n;i++){
            no_value[i] = scanner.nextInt();
        }
        int[][] dp = new int[n + 1][2];
        dp[0][0] = 0;dp[0][1] = 0;
        for(int i = 1;i <= n;i++){
            if(!used[i]){
                dp[i][0] = dp[i - 1][0] + value[i];
                used[i] = true;
                map.put(target[i - 1],i);
                dp[i][1] = dp[i - 1][1] + no_value[i];
            }else{
                int used_index = map.get(target[i - 1]);
                dp[i][0] = Math.max(dp[i - 1][0] + no_value[i],dp[i - 1][0] - dp[used_index][0] + dp[used_index][1] + value[i]);
            }
        }
    }
}
