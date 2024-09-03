package cn.dsxriiiii.LeetCode.LC150;

import java.util.HashSet;
import java.util.Set;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/11 15:37
 * @Email: lihh53453@hundsun.com
 * @Description: N皇后II 求符合N皇后的个数问题
 * 1.使用三个Set集合判断是否存在 如果存在则该节点的要求
 * 2.三个集合的规则 row+col为右上到左下的斜线  row-col为左上到右下的斜线  row为斜线
 * 3.col从0开始 row使用回溯 同时也从0开始
 * 4.二进制优化 目前没看懂
 */
public class LC52 {
    public int totalNQueens(int n) {
        Set<Integer> row_set = new HashSet<>();
        Set<Integer> dig_set_y = new HashSet<>();
        Set<Integer> dig_set_n = new HashSet<>();
        return dfs(n,0,row_set,dig_set_y,dig_set_n);
    }

    private int dfs(int n, int row, Set<Integer> rowSet, Set<Integer> digSetY, Set<Integer> digSetN) {
        if(row == n){
            return 1;
        }else{
            int count = 0;
//            for (int i = row; i < n; i++) {
            //这不是求组合问题 每次dfs都需要从0坐标位置开始
            for (int col = 0; col < n; col++) {
                if(rowSet.contains(col)) continue;
                if(digSetY.contains(row - col)) continue;
                if(digSetN.contains(row + col)) continue;
                rowSet.add(col);
                digSetY.add(row - col);
                digSetN.add(row + col);
                count +=dfs(n,row + 1,rowSet,digSetY,digSetN);
                rowSet.remove(col);
                digSetY.remove(row - col);
                digSetN.remove(row + col);
            }
            return count;
        }
    }
}
