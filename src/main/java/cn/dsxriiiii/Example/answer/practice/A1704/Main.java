package cn.dsxriiiii.Example.answer.practice.A1704;

public class Main {
    public static int ans = 0;
    public static int[][] arr = {{1,0},{-1,0},{0,-1},{0,1}};
    public static boolean[][] visit = new boolean[7][7];

    public static void main(String[] args) {
        visit[3][3] = true;
        dfs(3,3);
        System.out.println(ans / 4);
    }
    public static void dfs(int a,int b){
        if (a == 0 || a == 6 || b == 0 || b == 6){
            ans++;
            return;
        }
        visit[a][b] = true;
        visit[6-a][6-b] = true;
        for (int i = 0; i < 4; i++) {
            int new_a = a + arr[i][0];
            int new_b = b + arr[i][1];
            if (new_a < 0 || new_a > 6 || new_b < 0 || new_b > 6){
                continue;
            }
            if(!visit[new_a][new_b]){
                dfs(new_a,new_b);
            }
        }
        visit[a][b] = false;
        visit[6-a][6-b] = false;
    }
}
