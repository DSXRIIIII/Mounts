package cn.dsxriiiii.LeetCode;

/**
 * @PackageName: cn.dsxriiiii.LeetCode
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/08/17 17:32
 * @Description: 编辑距离
 **/
public class LC72 {
    public int minDistance(String word1, String word2) {
        if(word1 == null || word2 == null){
            return 0;
        }
        int len1 = word1.length();
        int len2 = word2.length();
        //初始化dp数组的长度 为长度加1
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i < len1 + 1 ; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < len2 + 1; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                //因为dp数组中坐标+1 所以扫描字符串需要-1 此时才能对应上原来的坐标
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }else{
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j],dp[i][j - 1]),dp[i-1][j- 1])+1;
                }
            }
        }
        return dp[len1][len2];
    }
}
