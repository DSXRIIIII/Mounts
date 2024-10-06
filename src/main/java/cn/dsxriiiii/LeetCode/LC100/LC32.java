package cn.dsxriiiii.LeetCode.LC100;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.LC100
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/06 14:04
 * @Description:
 **/
public class LC32 {
    public int longestValidParentheses(String s) {
        int len = s.length();
        int[] dp = new int[len];
        int max_ans = Integer.MIN_VALUE;
        for (int i = 1; i < len ; i++) {
            if(s.charAt(i) == ')'){
                if(s.charAt(i - 1) == '('){
                    dp[i] = i >= 2 ? dp[i - 2] + 2 : 0;
                }else if(i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '('){
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0);
                }
                max_ans = Math.max(max_ans, dp[i]);
            }
        }
        return max_ans;
    }
}
