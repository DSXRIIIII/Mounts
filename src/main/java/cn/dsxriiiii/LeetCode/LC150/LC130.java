package cn.dsxriiiii.LeetCode.LC150;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/7 17:03
 * @Email: lihh53453@hundsun.com
 * @Description: 被环绕的区域
 */
public class LC130 {
    int row;
    int col;
    public void solve(char[][] board) {
        if(board == null || board[0].length == 0) return;
        row = board.length;
        col = board[0].length;
        for (int i = 0; i < col; i++) {
            dfs(board,0,i);
            dfs(board,row - 1,i);
        }
        for (int i = 0; i < row; i++) {
            dfs(board,i,0);
            dfs(board,i,col - 1);
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(board[i][j] == 'A'){
                    board[i][j] = 'O';
                }else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }

    }
    public void dfs(char[][] board,int i,int j){
//        if(i < 0|| j < 0 || i >= row || j >= col || board[i][j] == 'X'){
//            return;
//        }
        //board[i][j] == 'X' 这里没有对'A'进行排除 否则就会报错 死循环
        // 死循环 -> [['O','O'],['O','O']]
        if(i < 0|| j < 0 || i >= row || j >= col || board[i][j] != 'O'){
            return;
        }
        board[i][j] = 'A';
        dfs(board,i+1,j);
        dfs(board,i-1,j);
        dfs(board,i,j+1);
        dfs(board,i,j-1);

    }
}
