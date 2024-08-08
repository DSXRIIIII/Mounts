package cn.dsxriiiii.LeetCode.LC150;

import cn.dsxriiiii.LeetCode.LC150.structure.TreeNode;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/6 9:22
 * @Email: lihh53453@hundsun.com
 * @Description: 路径总和
 */
public class LC112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        //if(root.val == targetSum) return true;
        //这里需要一个条件判断
        if(root.left == null && root.right == null){
            return targetSum == root.val;
        }
        return hasPathSum(root.left,targetSum - root.val) || hasPathSum(root.right,targetSum - root.val);
    }
}
