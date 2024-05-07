package cn.dsxriiiii.LanQiao.answer.practice.C.A1808;

import java.util.Scanner;
public class Main {
    static int N = 1010;
    static int[][] vis = new int[N][N];
    static int[][] temp = {{1,0},{-1,0},{0,-1},{0,1}};
    static int flag = 1;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] map = new char[n][n];
        int ans = 0;
        sc.nextLine();
        for(int i = 0; i < n; i++){
            map[i] = sc.nextLine().toCharArray();
        }
        sc.close();
        for(int i = 1; i < n - 1; i++){
            for(int j = 1;j < n - 1; j++){
                if(map[i][j] == '#' && vis[i][j] == 0){
                    flag = 0;
                    dfs(map,i,j);
                    if(flag == 0){
                        ans++;
                    }
                }
            }
        }
        System.out.println(ans);
    }
    public static void dfs(char[][] map,int x,int y){
        vis[x][y] = 1;
        if(map[x - 1][y] == '#' && map[x + 1][y] == '#' && map[x][y + 1] == '#' && map[x][y - 1] == '#'){
            flag = 1;
        }
        for(int i = 0; i < 4;i++){
            int nx = x + temp[i][0];
            int ny = y + temp[0][i];
            if(vis[nx][ny] == 0 && map[nx][ny] == '#'){
                dfs(map,nx,ny);
            }
        }
    }
}

