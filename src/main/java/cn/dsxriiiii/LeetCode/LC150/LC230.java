package cn.dsxriiiii.LeetCode.LC150;

import cn.dsxriiiii.LeetCode.LC150.structure.TreeNode;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/7 15:02
 * @Email: lihh53453@hundsun.com
 * @Description: 二叉搜索树中第K小的元素
 */
public class LC230 {
    int pre;
    int k; //将k转化为全局变量进行扣减
    public int kthSmallest(TreeNode root, int k) {
        pre = Integer.MAX_VALUE;
        this.k = k;
        dfs(root);
        return pre;
    }
    private void dfs(TreeNode root){
        if(root == null) return;
        if(k == 0) return; // 如果为0则已经找到匹配结果返回即可
        dfs(root.left);
        if(--k == 0) pre = root.val; //扣减为0时绑定数据
        dfs(root.right);
    }
}
