package cn.dsxriiiii.Example.tryfirst.A1701;

public class Main {
    static char[][] arr1 = new char[10][10];
    static int ans = 0;
    static int[][] arr2 = new int[10][10];
    static void dfs(int i,int j){
        if(i > 9 || i < 0 ||j > 9 || j < 0 ){
            ans++;
            return;
        }
        if(arr2[i][j] == 1){
            return;
        }
        arr2[i][j] = 1;
        if(arr1[i][j] == 'D'){
            dfs(i+1,j);
        }
        if(arr1[i][j] == 'R'){
            dfs(i,j+1);
        }
        if(arr1[i][j] == 'L'){
            dfs(i,j-1);
        }
        if(arr1[i][j] == 'U'){
            dfs(i-1,j);
        }
    }
    public static void main(String[] args){
        String[] test = {
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
            for (int j = 0; j <10; j++) {
                arr1[i][j] = test[i].charAt(j);
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    for (int l = 0; l < 10; l++) {
                        arr2[k][l] = 0;//错误在于k，l的修改而不是i和j，初始化arr2[][]
                    }
                }
                dfs(i,j);
            }
        }
        System.out.println(ans);
    }
}
