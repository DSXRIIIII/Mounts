package cn.dsxriiiii.PowerPointOffer;
/*
*
* leetcode LCR112
* https://leetcode.cn/problems/fpTFWP/description/
*
* */
public class LongestPathInMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        if(rows == 0 || cols == 0){
            //每一列每一行的长度至少是1
            return 0;
        }
        int longest = 0;
        int[][] lengths = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int length = dfs(matrix,lengths,i,j,rows,cols);
                longest = Math.max(length,longest);
            }
        }

        return longest;
    }
    public int dfs(int[][] matrix, int[][] lengths, int i, int j, int rows, int cols){
        if(lengths[i][j] != 0){
            return lengths[i][j];
        }
        int[][] dir = {{0,-1},{0,1},{1,0},{-1,0}};
        int length = 1;
        for(int[] next:dir){
            int var1 = next[0] + i;
            int var2 = next[1] + j;
            if(var1 >= 0 && var1 <rows && var2 >= 0 && var2 < cols && matrix[var1][var2] > matrix[i][j]){
                int path = dfs(matrix,lengths,var1,var2,rows,cols);
                //dfs算法自底而上，从1开始往上递增并且将取得到的路径值length赋值给lengths数组保存
                length = Math.max(path + 1,length);
            }
        }
        lengths[i][j] = length;
        return length;
    }

    public static void main(String[] args) {
        int[][] matrix = {{9,9,4},{6,6,8},{2,1,1}};
        LongestPathInMatrix longestPathInMatrix = new LongestPathInMatrix();
        int Result = longestPathInMatrix.longestIncreasingPath(matrix);
        System.out.println(Result);
    }
}
