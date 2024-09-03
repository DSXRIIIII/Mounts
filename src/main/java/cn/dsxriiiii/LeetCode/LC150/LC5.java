package cn.dsxriiiii.LeetCode.LC150;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.LC150
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/08/17 10:40
 * @Description: 最长回文字串
 * 判断回文串如果长度为1 那么此时为回文串
 * 长度i与j的位置差 == 1  相等即为回文串.两个字符是否相等
 * 长度位置差大于>1 此时字符相等  取决于上一个位置的两个字符是否相等
 **/
public class LC5 {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[s.length() + 1][s.length() + 1];
        String res = "";
        int maxLength = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            for(int j = i; j < n;j++){
                if(s.charAt(i) == s.charAt(j) && (j - i <= 1 || dp[i + 1][j - 1])){
                    dp[i][j] = true;
                    maxLength = Math.max(j - i,maxLength);
//                    if(maxLength < j - i){
//                        res = s.substring(i,j+1);
//                    } 如果这里不相等就不会有结果
                    if(maxLength <= j - i){
                        res = s.substring(i,j+1);
                    }
                }
            }
        }
        return res;
    }
}
