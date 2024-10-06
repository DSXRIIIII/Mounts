package cn.dsxriiiii.LeetCode.LC100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.LC100
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/04 17:21
 * @Description:
 **/
public class LC131 {
    boolean[][] dp;
    int n;
    List<List<String>> res;
    List<String> list;
    public List<List<String>> partition(String s) {
        n = s.length();
        res = new ArrayList<>();
        list = new ArrayList<>();
        dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i],true);
        }
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n ; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i - 1][j + 1];
            }
        }
        dfs(s, 0);
        return res;
    }

    private void dfs(String s, int index) {
        if(index == n){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int j = index; j < n ; j++) {
            if(dp[index][j]){
                list.add(s.substring(index,j+1));
                dfs(s,index + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
