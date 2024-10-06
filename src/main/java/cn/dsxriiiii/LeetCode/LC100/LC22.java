package cn.dsxriiiii.LeetCode.LC100;

import java.util.ArrayList;
import java.util.List;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.LC100
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/04 14:25
 * @Description: LC22
 **/
public class LC22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(res,sb,n,0,0);
        return res;
    }

    private void dfs(List<String> res, StringBuilder sb, int n, int left,int right) {
        if(sb.length() == n * 2){
            res.add(sb.toString());
            return;
        }
        if(left < n){
            sb.append('(');
            dfs(res, sb, n, left + 1, right);
            sb.deleteCharAt(sb.length() - 1);
        }else{
            sb.append(')');
            dfs(res,sb,n,left,right + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
