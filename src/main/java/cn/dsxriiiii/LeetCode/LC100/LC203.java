package cn.dsxriiiii.LeetCode.LC100;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.LC100
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/02 16:13
 * @Description:
 **/
public class LC203 {
    int pre;
    int k; //将k转化为全局变量进行扣减
    public int kthSmallest(TreeNode root, int k) {
        pre = Integer.MIN_VALUE;
        this.k = k;
        dfs(root);
        return pre;
    }
    public void dfs(TreeNode root){
        if(root == null) return;
        if(k == 0) return;
        dfs(root.left);
        if(--k == 0) pre = root.val;
        dfs(root.right);
    }
}
