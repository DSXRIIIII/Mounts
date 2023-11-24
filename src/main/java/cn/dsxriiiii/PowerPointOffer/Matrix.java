package cn.dsxriiiii.PowerPointOffer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Matrix {
    public int[][] updateMatrix(int[][] mat){
        int rows = mat.length;
        int cols = mat[0].length;
        int[][] dict_Arr = new int[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(mat[i][j] == 0){
                    queue.add(new int[]{i,j});
                    dict_Arr[i][j] = 0;
                }else{
                    dict_Arr[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int[][] addArr = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!queue.isEmpty()){
            int[] v = queue.remove();
            int dictNum = dict_Arr[v[0]][v[1]];
            for (int[] temp : addArr) {
                int v1 = temp[0] + v[0];
                int v2 = temp[1] + v[1];
                if(v1 >= 0 && v1 < rows && v2 >=0 && v2 < cols){
                    if(dict_Arr[v1][v2] > dictNum + 1){
                        dict_Arr[v1][v2] = dictNum + 1;
                        queue.add(new int[]{v1,v2});
                    }
                }
            }
        }
        return dict_Arr;
    }
    public static void main(String[] args) {
        Matrix matrixTest = new Matrix();
        int[][] mat = {{0,0,0},{0,1,0},{1,1,1}};
        int[][] Result = matrixTest.updateMatrix(mat);
        System.out.println(Arrays.deepToString(Result));
    }
}

