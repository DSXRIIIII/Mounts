package cn.dsxriiiii.LeetCode.LC100;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.LC100
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/03 13:12
 * @Description:
 **/
public class LC124 {
    private static int value;
    public int maxPathSum(TreeNode root) {
        value = Integer.MIN_VALUE;
        maxValue(root);
        return value;
    }

    private int maxValue(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = Math.max(maxValue(root.left), 0);
        int right =  Math.max(maxValue(root.right), 0);
        value = Math.max(value,left + right + root.val);
        return Math.max(left,right) + root.val;
    }
}
