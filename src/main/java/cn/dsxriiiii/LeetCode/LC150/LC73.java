package cn.dsxriiiii.LeetCode.LC150;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: Mounts
 * @Description: 矩阵置零
 * @Author: DSXRIIIII
 * @CreateDate: 2024/6/18 14:53
 * @Email: lihh53453@hundsun.com
 */
public class LC73 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        //boolean[][] arr = new boolean[len][len];
        boolean[] col = new boolean[n];
        boolean[] row = new boolean[m];
        //原本的想法是按照注释的那种 但是如果是对单行单列操作只需要一位数组就行了
        List<List<int[]>> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == 0){
                    col[j] = true;
                    row[i] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(col[j] || row[i]){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
