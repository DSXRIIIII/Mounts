package cn.dsxriiiii.LeetCode.LC150;

import cn.dsxriiiii.LeetCode.LC150.structure.TreeNode;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/6 16:38
 * @Email: lihh53453@hundsun.com
 * @Description: 二叉树的最近公共祖先
 */
public class LC236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /*
          返回条件：1.当前节点为空
                  2.找到了p节点
                  3.找到了q节点
         */
        if(root == null || p == root || q == root) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left == null) return right; //如果左子树为空 那么两个节点都在右子树
        if(right == null) return left; //如果右子树为空 那么两个节点都在左子树
        return root; //如果左子树和右子树都拿到值了 那么此时这个节点就是要找的节点
    }
}
