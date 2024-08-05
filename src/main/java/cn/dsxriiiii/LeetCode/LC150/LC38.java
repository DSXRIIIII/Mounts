package cn.dsxriiiii.LeetCode.LC150;

/**
 * @ProjectName: Mounts
 * @Description: 有效的数独
 * @Author: DSXRIIIII
 * @CreateDate: 2024/6/18 13:40
 * @Email: lihh53453@hundsun.com
 */
public class LC38 {
    public boolean isValidSudoku(char[][] board) {
        int[][] arr1 = new int[9][9];
        int[][] arr2 = new int[9][9];
        int[][][] arr3 = new int[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int index = c - '0' - 1;
                    arr1[i][index]++;
                    arr2[j][index]++;
                    arr3[i / 3][j / 3][index]++;
                    if (arr1[i][index] > 1 || arr2[j][index]++ > 1 || arr3[i / 3][j / 3][index] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
