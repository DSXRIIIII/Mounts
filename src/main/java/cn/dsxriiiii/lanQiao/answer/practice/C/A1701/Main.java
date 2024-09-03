package cn.dsxriiiii.lanQiao.answer.practice.C.A1701;

public class Main {
    static char[][] a = new char[10][10];
    static int[][] vis = new int[10][10];
    static int ans = 0;

    static void dfs(int i, int j) {
        if (i < 0 || i > 9 || j < 0 || j > 9) {
            ans++;
            return;
        }
        if (vis[i][j] == 1) {
            return;
        }
        vis[i][j] = 1;

        if (a[i][j] == 'L') {
            dfs(i, j - 1);
        }
        if (a[i][j] == 'R') {
            dfs(i, j + 1);
        }
        if (a[i][j] == 'U') {
            dfs(i - 1, j);
        }
        if (a[i][j] == 'D') {
            dfs(i + 1, j);
        }
    }

    public static void main(String[] args) {
        String[] input = {
                "UDDLUULRUL",
                "UURLLLRRRU",
                "RRUURLDLRD",
                "RUDDDDUUUU",
                "URUDLLRRUU",
                "DURLRLDLRL",
                "ULLURLLRDU",
                "RDLULLRDDD",
                "UUDDUDUDLL",
                "ULRDLUURRR"
        };

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                a[i][j] = input[i].charAt(j);//charAt()函数可以将字符串的元素取出来
            }
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    for (int l = 0; l < 10; l++) {
                        vis[k][l] = 0;
                    }
                }
                dfs(i,j);
            }
        }

        System.out.println(ans);
    }
}
