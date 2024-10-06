package cn.dsxriiiii.LeetCode.LC100;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.LC100
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/03 14:02
 * @Description:
 **/
public class LC994 {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] res = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        int number = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i,j,0});
                }else if(grid[i][j] == 1){
                    number++;
                }
            }
        }
        int max_time = 0;
        while(!queue.isEmpty()){
            int[] node = queue.poll();
            int i = node[0];
            int j = node[1];
            int time = node[2];
            max_time = Math.max(max_time, time);
            int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            for(int[] dirt : directions){
                int n_i = i + dirt[0];
                int n_j = j + dirt[1];
                if(n_i >= 0 && n_i < m && n_j >= 0 && n_j < n && grid[n_i][n_j] == 1){
                    queue.offer(new int[]{n_i,n_j,time + 1});
                    grid[n_i][n_j] = 2;
                    number--;
                }
            }
        }
        return number > 0 ? -1 : max_time;
    }
}
