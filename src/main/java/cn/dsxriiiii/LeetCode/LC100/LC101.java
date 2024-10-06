package cn.dsxriiiii.LeetCode.LC100;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.LC100
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/02 15:27
 * @Description: LC101
 **/
public class LC101 {
    public boolean isSymmetric(TreeNode root) {
        return check(root.left,root.right);
    }
    public boolean check(TreeNode left,TreeNode right){
        if(left == null && right == null){
            return true;
        }else if(left == null || right == null){
            return false;
        }else{
            return left.val == right.val && check(left.left,right.right) && check(left.right,right.left);
        }
    }
}
