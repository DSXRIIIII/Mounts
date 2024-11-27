package cn.dsxriiiii.LeetCode.LC100;

import java.util.Arrays;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.LC100
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/06 15:08
 * @Description:
 **/
public class LC72 {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < word1.length() + 1 ; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < word2.length() + 1; j++) {
            dp[0][j] = j;
        }
        for (int i = 1;i < word1.length() + 1;i++) {
            char c1 = word1.charAt(i - 1);
            for (int j = 1; j < word2.length() + 1; j++) {
                char c2 = word2.charAt(j - 1);
                if(c1 == c2){
                    dp[i][j] = dp[i - 1][j - 1];
                }else{
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j],dp[i][j - 1]),dp[i-1][j- 1])+1;
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        LC72 lc72 = new LC72();
        lc72.minDistance("ros","horse");
    }
}
