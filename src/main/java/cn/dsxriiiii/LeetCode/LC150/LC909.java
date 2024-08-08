package cn.dsxriiiii.LeetCode.LC150;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/8 16:29
 * @Email: lihh53453@hundsun.com
 * @Description: 蛇梯棋
 */
public class LC909 {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] vis = new boolean[n*n + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1,0});
        while(!queue.isEmpty()){
            int[] node = queue.poll();
            for(int i = 1;i <= 6;++i){
                int nxt = node[0] + i;
                if(nxt > n * n){
                    break;
                }
                int[] rc = change(nxt,n);
                if(board[rc[0]][rc[1]] > 0){
                    nxt = board[rc[0]][rc[1]];
                }
                if(nxt == n * n){
                    //return rc[1]+1; 这里不是坐标位置加1 而是节点位置+1
                    return node[1] + 1;
                }
                if(!vis[nxt]){
                    vis[nxt] = true;
                    queue.offer(new int[]{nxt,node[1]+1});//同上
                }
            }
        }
        return -1;
    }

    public int[] change(int next,int n) {
        int row = (next - 1) / n;
        int col = (next - 1) % n;
        if(row % 2 == 1){
            col = n - 1 - col;
        }
        return new int[]{n - 1 - row,col};
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, 13, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 15, -1, -1, -1, -1}
        };
        LC909 lc909 = new LC909();
        lc909.snakesAndLadders(matrix);
    }
}
