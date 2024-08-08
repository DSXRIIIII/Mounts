package cn.dsxriiiii.LeetCode.LC150;

import cn.dsxriiiii.LeetCode.LC150.structure.TreeNode;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/6 9:32
 * @Email: lihh53453@hundsun.com
 * @Description: 求根节点到叶节点的数字之和
 * 向下传递路径和 4 7 5 6 向7 传递47 但是返回475 + 476
 */
public class LC129 {
    public int sumNumbers(TreeNode root) {
        return dfs(root,0);
    }
    private int dfs(TreeNode root,int sum){
        if(root == null) return 0;
        sum = sum * 10 + root.val;
        if(root.left == null && root.right == null){
            return sum;
        }else {
            return dfs(root.left,sum) + dfs(root.right,sum);
        }
    }
}
