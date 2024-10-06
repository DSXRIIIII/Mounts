package cn.dsxriiiii.LeetCode.LC100;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.LC100
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/03 13:43
 * @Description:
 **/
public class LC200 {
    private static int m;
    private static int n;
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == '1'){
                    res++;
                    dfs(i,j,grid);
                }
            }
        }
        return res;
    }

    private void dfs(int i, int j,char[][] grid) {
        if(i < 0 || i > m - 1 || j < 0 || j > n - 1 || grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0';
        dfs(i + 1,j,grid);
        dfs(i - 1,j,grid);
        dfs(i,j + 1,grid);
        dfs(i,j - 1,grid);
    }
}
