package cn.dsxriiiii.LeetCode.LC150;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/7 16:17
 * @Email: lihh53453@hundsun.com
 * @Description: 被围绕的区域
 */
public class LC200 {
    int row;
    int col;
    public int numIslands(char[][] grid) {
        if(grid == null ||  grid.length == 0 || grid[0].length == 0) return 0;
        row = grid.length;
        col = grid[0].length;
        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(grid[i][j] == '1'){
                    res++;
                    dfs(grid,i,j);
                }
            }
        }
        return res;
    }
    public void dfs(char[][] grid,int i,int j){
        if(i < 0 || j < 0 || i >= row || j >= col || grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0';
        dfs(grid,i + 1,j);
        dfs(grid,i - 1,j);
        dfs(grid,i,j + 1);
        dfs(grid,i,j - 1);
    }
}
