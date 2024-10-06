package cn.dsxriiiii.LeetCode.LC100;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.LC100
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/01 14:35
 * @Description: LC73
 **/
public class LC73 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] bm = new boolean[m];
        boolean[] bn = new boolean[n];
        for(int i = 0;i < m;i++){
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == 0){
                    bm[i] = true;
                    bn[j] = true;
                }
            }
        }
        for(int i = 0;i < m;i++){
            for (int j = 0; j < n; j++) {
                if(bm[i] || bn[j]){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
