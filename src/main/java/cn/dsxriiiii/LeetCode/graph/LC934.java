package cn.dsxriiiii.LeetCode.graph;

import cn.dsxriiiii.json.JsonTest;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.graph
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/31 10:36
 * @Description:
 **/
public class LC934 {
    public static void main(String[] args) {
        int[][] grid = {{1,1,1,1,1},{1,0,0,0,1},{1,0,1,0,1},{1,0,0,0,1},{1,1,1,1,1}};
        LC934 lc934 = new LC934();
        lc934.shortestBridge(grid);
    }
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 1){
                    queue.offer(new int[]{i,j});
                    dfs(i,j,grid,queue);
                    int step = 0;
                    while(!queue.isEmpty()){
                        int size = queue.size();
                        for (int k = 0; k < size; k++) {
                            int[] index = queue.poll();
                            for(int[] direction:dirs){
                                int new_i = direction[0] + index[0];
                                int new_j = direction[1] + index[1];
                                if(new_i >= 0 && new_i < n && new_j >= 0 && new_j < n && grid[new_i][new_j] != -1){
                                    if(grid[new_i][new_j] == 0){
                                        queue.offer(new int[]{new_i,new_j});
                                        grid[new_i][new_j] = -1;
                                    }else if(grid[new_i][new_j] == 1){
                                        return step;
                                    }
                                }
                            }
                        }
                        step++;
                    }
                }
            }
        }
        return 0;
    }

    public void dfs(int x, int y, int[][] grid, Queue<int[]> queue) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y]!= 1) {
            return;
        }
        grid[x][y] = -1;
        queue.offer(new int[]{x,y});
        dfs(x - 1, y, grid, queue);
        dfs(x + 1, y, grid, queue);
        dfs(x, y - 1, grid, queue);
        dfs(x, y + 1, grid, queue);
    }

}
