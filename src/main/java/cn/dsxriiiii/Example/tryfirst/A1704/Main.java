package cn.dsxriiiii.Example.tryfirst.A1704;
public class Main {
    private static int ans = 0;
    private static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    private static boolean[][] visit = new boolean[7][7];
    public static void main(String[] args) {
        visit[3][3] = true;
        dfs(3,3);
        System.out.println(ans / 4);
    }
    private static void dfs(int x,int y){
        if (x == 0 || y == 0 || x == 6 || y == 6){
            ans ++;
            return;
        }
        visit[x][y] = true;
        visit[6 - x][6 - y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if (nx < 0 || nx > 6 || ny < 0 || ny > 6)
                continue;
            if (!visit[nx][ny])
                dfs(nx,ny);
        }
        visit[x][y] = false;
        visit[6 - x][6 - y] = false;
    }
}