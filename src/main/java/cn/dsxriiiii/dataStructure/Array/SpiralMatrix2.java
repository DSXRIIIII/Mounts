package cn.dsxriiiii.dataStructure.Array;

import java.util.Arrays;
/*
* for (int i = l;i <= r;i++) mat[t][i] = num++;  t++
* 边界递增问题，在1，2，3的过程之中，l逐渐向r递增，并且赋值，当到达r边界时；停止进入下一次循环
* 此时第一层已经满了，那么就删除第一层即更新下标位置，将t++，删除上边界
* for (int i = t;i <= d;i++) mat[i][r] = num++;  r--;
* 边界递增问题，在4，5的过程之中，t逐渐向d递增，并且赋值，当到达d边界时；停止进入下一次循环
* 此时最右边的最外层已经满了，那么就删除最外层层即更新下标位置，将r--，为什么是--，因为是在最右侧，所以删除右边界
* */
public class SpiralMatrix2 {
    public static void main(String[] args) {
        SpiralMatrix2 spiralMatrix2 = new SpiralMatrix2();
        int[][] result = spiralMatrix2.generateMatrix(3);
        System.out.println(Arrays.deepToString(result));
    }
    public int[][] generateMatrix(int n){
        int l = 0;
        int r = n - 1;
        int t = 0;
        int d = n - 1;
        int[][] mat = new int[n][n];
        int target = n * n;
        int num = 1;
        while(num <= target){
            for (int i = l;i <= r;i++) mat[t][i] = num++;
            t++;
            for (int i = t;i <= d;i++) mat[i][r] = num++;
            r--;
            for (int i = r;i >= l;i--) mat[d][i] = num++;
            d--;
            for (int i = d;i >= t;i--) mat[i][l] = num++;
            l++;
        }
        return mat;
    }
}
