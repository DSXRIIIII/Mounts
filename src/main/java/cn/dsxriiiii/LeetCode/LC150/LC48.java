package cn.dsxriiiii.LeetCode.LC150;

/**
 * @ProjectName: Mounts
 * @Description: 旋转图像
 * @Author: DSXRIIIII
 * @CreateDate: 2024/6/18 14:47
 * @Email: lihh53453@hundsun.com
 */
public class LC48 {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        int[][] new_matrix = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                new_matrix[j][len - i - 1] = matrix[i][j];  //找到此处的数学规律即可
            }
        }
        for (int i = 0; i < len; i++) {
            System.arraycopy(new_matrix[i], 0, matrix[i], 0, len);
        }
    }
}
