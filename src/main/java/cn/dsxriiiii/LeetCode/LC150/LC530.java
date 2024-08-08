package cn.dsxriiiii.LeetCode.LC150;

import cn.dsxriiiii.LeetCode.LC150.structure.TreeNode;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/7 14:18
 * @Email: lihh53453@hundsun.com
 * @Description: 二叉搜索树的最小绝对差
 */
public class LC530 {
    int pre;
    int res;
    public int getMinimumDifference(TreeNode root) {
        res = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return res;
    }
    private void dfs(TreeNode root){
        if(root == null) return;
        dfs(root.left);
        if (pre != -1) {
            res = Math.min(res, root.val - pre);
        }
        pre = root.val; //保存上一节点值
        dfs(root.right);
    }
}
