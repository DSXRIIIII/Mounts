package cn.dsxriiiii.LeetCode.LC100;

import java.util.ArrayList;
import java.util.List;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.LC100
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/01 14:44
 * @Description: LC54
 **/
public class LC54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int l = 0,r = matrix[0].length - 1;
        int u = 0,d = matrix.length - 1;
        List<Integer> ans = new ArrayList<>();
        while (l <= r && u <= d) {
            for (int i = l; i <= r; i++) {
                ans.add(matrix[u][i]);
            }
            u++;
            for(int i = u;i <= d;i++){
                ans.add(matrix[i][r]);
            }
            r--;
            if(u <= d){
                for (int i = r; i >= l ; i--) {
                    ans.add(matrix[d][i]);
                }
            }
            d--;
            if(l <= r){
                for (int i = d; i >= u; i--) {
                    ans.add(matrix[i][l]);
                }
            }
            l++;
        }
        return ans;
    }
}
