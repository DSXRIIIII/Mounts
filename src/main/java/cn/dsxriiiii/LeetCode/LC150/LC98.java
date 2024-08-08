package cn.dsxriiiii.LeetCode.LC150;

import cn.dsxriiiii.LeetCode.LC150.structure.TreeNode;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/7 15:34
 * @Email: lihh53453@hundsun.com
 * @Description: 验证二叉搜索树
 */
public class LC98 {
    long pre = Long.MIN_VALUE; //Integer.MIN_VALUE 和例子冲突 0x8000000000000000L为最小值
    boolean res;
    public boolean isValidBST(TreeNode root) {
        res = true;
        dfs(root);
        return res;
    }
    public void dfs(TreeNode root){
        if(root == null) return;
        if(!res) return; //检查res是否已经更新为false;
        dfs(root.left);
        if(root.val > pre){
            pre = root.val; //更新pre值
        }else{
            res = false;
        }
        dfs(root.right);
    }
}
