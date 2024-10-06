package cn.dsxriiiii.LeetCode.LC100;

import cn.hutool.core.lang.hash.Hash;

import java.util.*;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.LC100
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/04 17:51
 * @Description: Lc51
 **/
public class LC51 {
    static List<List<String>> res;
    static int[] index;
    Set<Integer> cols;
    Set<Integer> one;
    Set<Integer> two;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        index = new int[n];
        cols = new HashSet<>();
        one = new HashSet<>();
        two = new HashSet<>();
        Arrays.fill(index,-1);
        List<String> temp = new ArrayList<>();
        dfs(0,n);
        return res;
    }

    private void dfs(int row, int n) {
        if(row == n){
            List<String> board = buildNQueen(index, n);
            res.add(board);
            return;
        }
        for (int i = 0; i < n; i++) {
            if(cols.contains(i)) continue;
            if(one.contains(i + row)) continue;
            if(two.contains(row - i)) continue;
            cols.add(i);
            one.add(i + row);
            two.add(row - i);
            index[row] = i;
            dfs(row + 1,n);
            index[row] = -1;
            cols.remove(i);
            one.remove(i + row);
            two.remove(row - i);
        }
    }

    private List<String> buildNQueen(int[] index, int n) {
        List<String> board = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row,'.');
            row[index[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}
