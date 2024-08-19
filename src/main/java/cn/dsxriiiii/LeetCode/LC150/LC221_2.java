package cn.dsxriiiii.LeetCode.LC150;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.LC150
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/08/19 11:27
 * @Description: 最大正方形
 * 简单递推
 * 1.边界为0时如果为1就初始化为1
 * 2.不为0时找到左上 左 上 三个位置 找到最小值+1
 * 3.比较的到最大的边长
 **/
public class LC221_2 {
    public int maximalSquare(char[][] matrix) {
        int res = 0;
        int max_len = 0;
        if(matrix.length == 0 || matrix[0].length == 0){
            return res;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(matrix[i][j] == 1){
                    if(i == 0 || j == 0){
                        dp[i][j] = 1;
                    }else{
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j],dp[i][j - 1]),dp[i - 1][j - 1])+1;
                    }
                    max_len = Math.max(max_len,dp[i][j]);
                }
            }
        }
        return max_len*max_len;
    }
}
