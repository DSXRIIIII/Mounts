package cn.dsxriiiii.LeetCode.LC150;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/12 15:32
 * @Email: lihh53453@hundsun.com
 * @Description: 搜索二维矩阵
 * 二分查找
 * 将二位数组转化为一维
 * 坐标位置就是matrix[mid/matrix[0].length][mid%matrix[0].length]
 * 注意区分行列
 */
public class LC74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        //int right = matrix.length * matrix[0].length;
        int right = matrix.length * matrix[0].length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            //int value = matrix[mid/matrix.length][mid%matrix.length];
            int value = matrix[mid/matrix[0].length][mid%matrix[0].length];
            if(target < value){
                right = mid - 1;
            }else if(target > value){
                left = mid + 1;
            }else{
                return true;
            }
        }
        return false;
    }
}
