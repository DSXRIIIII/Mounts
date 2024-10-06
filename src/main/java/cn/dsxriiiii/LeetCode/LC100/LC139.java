package cn.dsxriiiii.LeetCode.LC100;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.LC100
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/06 0:35
 * @Description:
 **/
public class LC139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()];
        dp[0] = true;
        for (int i = 1; i < s.length(); i++) {
            for(int j = 0;j < i;j++){
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length() - 1];
    }
}
