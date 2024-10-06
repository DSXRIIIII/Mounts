package cn.dsxriiiii.LeetCode.LC100;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.LC100
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/02 16:05
 * @Description: LC98
 **/
public class LC98 {
    long pre = Long.MIN_VALUE;
    boolean res;
    public boolean isValidBST(TreeNode root) {
        res = true;
        dfs(root);
        return res;
    }
    public void dfs(TreeNode root){
        if(root == null) return;
        dfs(root.left);
        if(root.val < pre){
            res = false;
        }else{
            pre = root.val;
        }
        dfs(root.right);
    }
}
