package cn.dsxriiiii.LeetCode.LC150;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: Mounts
 * @Description: 螺旋矩阵
 * @Author: DSXRIIIII
 * @CreateDate: 2024/6/18 14:00
 * @Email: lihh53453@hundsun.com
 */
public class LC54 {
    public static void main(String[] args) {
        int[][] arr = {{2,5,8},{4,0,-1}};
        System.out.println(spiralOrder(arr));
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int up = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        while(true){
            for(int i = left;i <= right;i++) res.add(matrix[up][i]);
            if(++up > down) break;
            for (int j = up; j <= down; j++) res.add(matrix[j][right]);
            if(--right < left) break;
            for (int m = right; m >= left ; m--) res.add(matrix[down][m]);
            if(--down < up) break;
            for (int n = down; n >= up; n--) res.add(matrix[n][left]);
            if(++left > right) break;
        }
        return res;
    }
}

