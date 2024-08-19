package cn.dsxriiiii.LeetCode.LC150;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.LC150
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/08/17 11:24
 * @Description: 交错字符串
 * 对于s3的字符串位置x=i + j - 1 取决于和字符串s1的 i - 1位置 或者 s2的j - 1位置是否相等
 * 并且继承前一位 dp[i - 1][0] 或者 dp[0][j - 1]
 * 情况1.s1 所有在字符与 s3 相等 所以就是一维的dp数组
 * 情况2.s2 所有在字符与 s3 相等 所以就是一维的dp数组
 * 情况3.s1 起始位置不在0位置开始 取决与前一位boolean值 和 s1的下一位或者 s2 的下一位
 **/
public class LC97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length();
        int l2 = s2.length();
        int l3 = s3.length();
        if(l1  + l2 != l3) {
            return false;
        }
        boolean[][] dp =  new boolean[l1 + 1][l2 + 1];
        //初始化dp数组
        dp[0][0] = true;
        for (int i = 1; i < l1; i++) {
            //比较前一位的位置
            //dp[i][0] = dp[i - 1][0] && s1.charAt(i) == s3.charAt(i);
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        for (int j = 1; j < l2; j++) {
            //dp[0][j] = dp[0][j - 1] && s1.charAt(j) == s3.charAt(j);
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }
        for (int i = 1; i < l1 ; i++) {
            for (int j = 1; j < l2; j++) {
                boolean resI = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                boolean resJ = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                dp[i][j] = resJ || resI;
            }
        }
        return dp[l1][l2];
    }
}
