package cn.dsxriiiii.LeetCode.LC150;

import cn.dsxriiiii.LeetCode.LC150.structure.TreeNode;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/6 16:25
 * @Email: lihh53453@hundsun.com
 * @Description: 完全二叉树的节点个数
 * 递归计算即可
 */
public class LC222 {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int left = countNodes(root.left);
        int right = countNodes(root.right);
        return left + right + 1;
    }
}
