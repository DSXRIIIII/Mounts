package cn.dsxriiiii.LeetCode.LC150;

import cn.dsxriiiii.LeetCode.LC150.structure.TreeNode;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/6 9:58
 * @Email: lihh53453@hundsun.com
 * @Description: 二叉树中的最大路径和
 * 解析如图
 */
public class LC124 {
    int max_value = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return max_value;
    }
    public int maxSum(TreeNode root){
        if(root == null) return 0;

        int left = Math.max(maxSum(root.left),0);
        int right = Math.max(maxSum(root.right),0);
        int nowVal = left + right + root.val;
        max_value = Math.max(max_value,nowVal);
        return root.val + Math.max(left,right);
    }
}
