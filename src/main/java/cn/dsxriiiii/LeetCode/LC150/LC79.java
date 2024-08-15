package cn.dsxriiiii.LeetCode.LC150;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/11 16:27
 * @Email: lihh53453@hundsun.com
 * @Description: 单词搜索
 * 思路：
 * dfs逻辑：1.最后一个字母与单词word最后一个字母相同并且长度与word长度相同
 *         2.匹配index++位置的单词
 * 回溯逻辑：visit[i][j] = true -> false; 匹配完该节点重新将该节点状态返回
 */
public class LC79 {
    private boolean flag = false;
    private boolean[][] visit;
    private final int[][] dict = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public boolean exist(char[][] board, String word) {
        visit = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j <board[0].length; j++) {
                if(board[i][j] != word.charAt(0)) continue; //剪枝
                dfs(i, j, word, 0, board);
                if(flag) return true;
            }
        }
        return false;
    }

    private void dfs(int i, int j, String word, int index, char[][] board) {
        if(flag) return;//剪枝
        if(board[i][j] != word.charAt(index)){
            return;
        }
        if(index == word.length() - 1){
            flag = true;
        }
        visit[i][j] = true;
        for(int[] arr:dict){
            int new_i = arr[0] + i;
            int new_j = arr[1] + j;
            if(new_i >=0 && new_j >=0 && new_i < board.length && new_j < board[0].length){
                if(!visit[new_i][new_j]){
                    dfs(new_i,new_j,word,index+1,board);
                }
            }
        }
        visit[i][j] = false;
    }
}
