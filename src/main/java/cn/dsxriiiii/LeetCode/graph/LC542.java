package cn.dsxriiiii.LeetCode.graph;

import cn.hutool.core.util.StrUtil;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.graph
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/11/02 17:07
 * @Description:
 **/
public class LC542 {
    private final int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==1&&!inVoid(mat,i,j)){
                    mat[i][j]=Integer.MAX_VALUE;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==1){
                    dfs(mat,i,j);
                }
            }
        }
        return mat;
    }

    private void dfs(int[][] mat, int i, int j) {
        for(int [] direction : dir){
            int new_i = i + direction[0];
            int new_j = j + direction[1];
            if(new_i >= 0 && new_j >=0 && new_i < mat.length && new_j < mat[0].length && mat[new_i][new_j]>mat[i][j]+1){
                mat[new_i][new_j]=mat[i][j]+1;
                dfs(mat,new_i,new_j);
            }

        }
    }

    public boolean inVoid(int[][] arr,int i,int j){
        for(int[] direction : dir){
            int new_i = direction[0] + i;
            int new_j = direction[1] + j;
            if(new_i >= 0 && new_j >=0 && new_i < arr.length && new_j < arr[0].length && arr[new_i][new_j] == 0) return true;
        }
        return false;
    }
}
