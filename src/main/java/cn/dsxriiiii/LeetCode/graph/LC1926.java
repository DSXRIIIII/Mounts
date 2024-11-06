package cn.dsxriiiii.LeetCode.graph;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.graph
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/31 0:01
 * @Description:
 **/
public class LC1926 {
    private final static int[][] directions = {{0,-1},{0,1},{1,0},{-1,0}};
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        List<int[]> list = new ArrayList<>();
        maze[entrance[0]][entrance[1]] = '+';
        Deque<int[]> queue = new LinkedList<>();
        int start = entrance[0] * n + entrance[1];
        queue.offer(new int[]{start,0});
        while(!queue.isEmpty()){
            int[] node = queue.poll();
            for(int[] index : directions){
                int i = node[0] / n + index[0];
                int j = node[0] % n + index[1];
                int len = node[1];
                if(i < 0 || i >= m || j < 0 || j >= n  || maze[i][j] == '+') continue;
                if(i == 0 || i == m - 1 || j == 0 || j == n - 1) return len + 1;
                int newNode = i * m + j;
                queue.offer(new int[]{newNode,len + 1});
                maze[i][j] = '+';
            }
        }
        return -1;
    }
}
