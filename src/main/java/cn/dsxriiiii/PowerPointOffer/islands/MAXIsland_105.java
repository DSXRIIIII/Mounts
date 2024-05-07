package cn.dsxriiiii.PowerPointOffer.islands;

import java.util.LinkedList;
import java.util.Queue;

public class MAXIsland_105 {
    public static void main(String[] args){
        int[][] grid = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };
        int maxAreaIslandSize = maxAreaIsland(grid);
        System.out.println("最大的岛屿面积为"+maxAreaIslandSize);
        int IslandNum = IslandNumber(grid);
        System.out.println("岛屿数量为" + IslandNum);
        int closeIslandNumber = closedIsland(grid);
        System.out.println("封闭的岛屿数量为"+closeIslandNumber);
    }
    public static int maxAreaIsland(int[][] island){
        int m = island.length;
        int n = island[0].length;
        int[][] visit = new int[m][n];
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(visit[i][j] == 0 && island[i][j] == 1){
                    int area = maxAreaIsland_dfs(i,j,visit,island);
                    //int area = maxAreaIsland_bfs(i,j,visit,island);
                    maxArea = Math.max(area,maxArea);
                }
            }
        }
        return maxArea;
    }
    public static int IslandNumber(int[][] island){
        int m = island.length;
        int n = island[0].length;
        boolean[][] visit = new boolean[m][n];
        int final_num = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++){
                if(island[i][j] == 1 && !visit[i][j]){
                    final_num++;
                    IslandNumber_dfs(i,j,visit,island);
                    //IslandNumber_bfs(i,j,visit,island);
                }
            }
        }
        return final_num;
    }
    public static int islandPerimeter(int[][] grid){
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = {{0,1},{0,-1},{-1,0},{1,0}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 1){
                    int cnt = 0;
                    for(int[] temp:dirs){
                        int next_x = temp[0] + i;
                        int next_y = temp[1] + j;
                        if(next_x < 0 || next_y < 0 || next_x > m || next_y > n || grid[next_x][next_y] == 0){
                            cnt++;
                        }
                    }
                    ans+=cnt;
                }
            }
        }
        return ans;
    }
    public static int closedIsland(int[][] island){
        int m = island.length;
        int n = island[0].length;
        int ans = 0;
        for(int i = 0;i < m; i++){
            for(int j = 0; j < n; j++){
                if(island[i][j] == 1 && closedIsland_dfs(i,j,island,m,n)){
                    ans++;
                }
            }
        }
        return ans;
    }
    public static boolean closedIsland_dfs(int i, int j, int[][] island, int m, int n){
        if(i >= m || j >= n || i < 0 || j < 0){
            return false;
        }
        if(island[i][j] != 1){
            return true;
        }
        island[i][j] = -1;
        boolean ret1 = closedIsland_dfs(i+1,j,island,m,n);
        boolean ret2 = closedIsland_dfs(i-1,j,island,m,n);
        boolean ret3 = closedIsland_dfs(i,j+1,island,m,n);
        boolean ret4 = closedIsland_dfs(i,j-1,island,m,n);
        return ret1&&ret2&&ret3&&ret4;
    }
    public static boolean closedIsland_bfs(int i, int j,int[][] island,int m, int n){
        return false;
    }

    public static void IslandNumber_dfs(int i,int j,boolean[][] visit,int[][] island){
        int m = island.length;
        int n = island[0].length;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        for(int[] temp:dirs){
            for (int k = 0; k < dirs.length; k++) {
                int next_x = i + temp[0];
                int next_y = j + temp[1];
                if(next_x >= 0 && next_x < m && next_y >= 0 && next_y < n && !visit[next_x][next_y] && island[next_x][next_y] == 1){
                    visit[next_x][next_y] = true;
                    IslandNumber_dfs(next_x,next_y,visit,island);
                }
            }
        }
    }
    public static void IslandNumber_bfs(int i, int j, boolean[][] visit, int[][] island){
        int m = island.length;
        int n = island[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i,j});
        while(!queue.isEmpty()){
            int[] node = queue.remove();
            int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
            for (int[] temp : dir) {
                int next_x = node[0] + temp[0];
                int next_y = node[1] + temp[1];
                if(next_x >= 0 && next_x < m && next_y >=0 && next_y < n){
                    visit[next_x][next_y] = true;
                    queue.add(new int[]{next_x,next_y});
                }
            }
        }
    }
    public static int maxAreaIsland_dfs(int i, int j, int[][] visit,int[][] island){
        int area = 1;
        visit[i][j] = 1;
        int m = island.length;
        int n = island[0].length;
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        for (int[] ints : dir) {
            int next_x = i + ints[0];
            int next_y = j + ints[1];
            if (next_x >= 0 && next_x < m && next_y >= 0 && next_y < n && island[next_x][next_y] == 1 && visit[next_x][next_y] != 1) {
                area +=maxAreaIsland_dfs(next_x, next_y, visit, island);
            }
        }
        return area;
    }
    public static int maxAreaIsland_bfs(int i, int j, int[][] visit,int[][] island){
        Queue<int[]> queue = new LinkedList<>();
        int m = island.length;
        int n = island[0].length;
        queue.add(new int[]{i,j});
        visit[i][j] = 1;
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        int area = 0;
        while(!queue.isEmpty()){
            area++;
            int[] node = queue.remove();
            for (int[] ints : dir) {
                int next_x = node[0] + ints[0];
                int next_y = node[1] + ints[1];
                if (next_x >= 0 && next_x < m && next_y >= 0 && next_y < n && island[next_x][next_y] == 1 && visit[next_x][next_y] != 1) {
                    queue.add(new int[]{next_x,next_y});
                    visit[next_x][next_y] = 1;
                }
            }
        }
        return area;
    }
}
