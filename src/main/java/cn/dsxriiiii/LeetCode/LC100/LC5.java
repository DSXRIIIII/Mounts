package cn.dsxriiiii.LeetCode.LC100;

import java.net.InetSocketAddress;
import java.util.Arrays;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.LC100
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/06 14:36
 * @Description:
 **/
public class LC5 {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length() + 1][s.length() + 1];
        int max_len = 0;
        String res = "";
        for (int i = s.length() - 1; i >= 0 ; i--) {
            for (int j = i; j < s.length() ; j++) {
                if(s.charAt(i) == s.charAt(j) && (j - i <= 1 || dp[i - 1][j + 1])){
                    dp[i][j] = true;
                    max_len = Math.max(j - i,max_len);
                    if(j - i >= max_len) {
                        res = s.substring(i, j + 1);
                    }
                }
            }
        }
        return res;
    }
}
