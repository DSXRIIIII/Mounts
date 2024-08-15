package cn.dsxriiiii.LeetCode.LC150;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/11 16:06
 * @Email: lihh53453@hundsun.com
 * @Description: 括号生成
 * 思路：dfs条件 左括号数量 < n(最大括号数) 可以不断添加
 *             右括号数量 < 左括号数 可以不断添加
 * 更新括号数量
 * dfs结束条件:StringBuilder的长度为n*2
 */
public class LC22 {
    public List<String> generateParenthesis(int n) {
        List<String> res= new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        dfs(stringBuilder,res,0,0,n);
        return res;
    }

    private void dfs(StringBuilder stringBuilder, List<String> res, int left, int right, int n) {
        if(stringBuilder.length() == n * 2){
            res.add(stringBuilder.toString());
        }else{
            if(left < n){
                stringBuilder.append("(");
                dfs(stringBuilder,res,left+1,right,n);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
            if(left > right){
                stringBuilder.append(")");
                dfs(stringBuilder,res,left,right + 1,n);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
        }
    }
}
