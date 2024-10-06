package cn.dsxriiiii.LeetCode.LC100;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.LC100
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/04 18:28
 * @Description:
 **/
public class LC74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int start = 0;
        int end = m * n - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            int mid_value = matrix[mid/m][mid%m];
            if(mid_value > target){
                end = mid - 1;
            }
            if(mid_value < target){
                start = start + 1;
            }
            if(mid_value == target){
                return true;
            }
        }
        return false;
    }
}
