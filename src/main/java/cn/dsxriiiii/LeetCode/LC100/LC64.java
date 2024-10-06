package cn.dsxriiiii.LeetCode.LC100;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.LC100
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/06 14:28
 * @Description:
 **/
public class LC64 {
    public int minPathSum(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(i == 0 && j == 0){
                    continue;
                }else if(i == 0){
                    grid[i][j] = grid[i][j - 1] + grid[i][j];
                }else if(j == 0){
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                }else{
                    grid[i][j] = Math.min(grid[i][j - 1],grid[i - 1][j]) + grid[i][j];
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
