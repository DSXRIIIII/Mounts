package cn.dsxriiiii.LeetCode.LC100;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.LC100
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/04 14:55
 * @Description:
 **/
public class LC79 {
    private boolean flag;
    private boolean[][] visit;
    private final int[][] dirt = {{0,1},{0,-1},{-1,0},{1,0}};
    public boolean exist(char[][] board, String word) {
        flag = false;
        int m = board.length;
        int n = board[0].length;
        visit = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(!visit[i][j]){
                    if(board[i][j] != word.charAt(0)) continue;
                    dfs(i,j,board,word,0);
                    if(flag) return true;
                }
            }
        }
        return false;
    }

    private void dfs(int i, int j, char[][] board, String word, int index) {
        if(flag) return;
        if(board[i][j] != word.charAt(index)){
            return;
        }
        visit[i][j] = true;
        for(int[] dir : dirt){
            int new_i = dir[0] + i;
            int new_j = dir[1] + j;
            if(new_i >=0 && new_i < board.length && new_j >= 0 && new_j < board[0].length){
                dfs(new_i,new_j,board,word,index + 1);
            }
        }
        visit[i][j] = false;
    }
}
