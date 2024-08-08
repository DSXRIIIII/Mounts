package cn.dsxriiiii.LeetCode.LC150;

import cn.dsxriiiii.LeetCode.LC150.structure.TreeNode;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/5 10:38
 * @Email: lihh53453@hundsun.com
 * @Description: 反转二叉树
 */
public class LC226 {
    public TreeNode invertTree_dfs(TreeNode root) {
        if(root == null) return null;
        TreeNode left = invertTree_dfs(root.left);
        TreeNode right = invertTree_dfs(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
