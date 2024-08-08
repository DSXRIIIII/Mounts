package cn.dsxriiiii.LeetCode.LC150;

import cn.dsxriiiii.LeetCode.LC150.structure.TreeNode;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/5 10:59
 * @Email: lihh53453@hundsun.com
 * @Description:
 */
public class LC101 {
    public boolean isSymmetric(TreeNode root) {
        return check(root.left,root.right);
    }
    private boolean check(TreeNode left,TreeNode right){
        if(left == null && right == null){
            return true;
        }else if(left == null || right == null){
            return false;
        }else{
            return left.val == right.val && check(left.right,right.left) && check(right.right,left.left);
        }
    }
}
