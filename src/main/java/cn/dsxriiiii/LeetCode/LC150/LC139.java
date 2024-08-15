package cn.dsxriiiii.LeetCode.LC150;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/15 9:16
 * @Email: lihh53453@hundsun.com
 * @Description:
 */
public class LC139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int len = s.length() + 1;
        boolean[] dp = new boolean[len];
        dp[0] = true;
        for (int i = 1; i <= s.length() ; i++) {
            for (int j = 0; j < i; j++) {
                //subString的范围为[j,i) 所以不会取到i
                //实际dp取决于i前的[j,i）的范围
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len - 1];
    }
}
