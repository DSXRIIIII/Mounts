package cn.dsxriiiii.LeetCode.LC100;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.LC100
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/02 15:34
 * @Description: LC543
 **/
public class LC543 {
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0; // 访问到空节点了，返回0
        }
        int L = depth(root.left); // 左儿子为根的子树的深度
        int R = depth(root.right);
        ans = Math.max(L+R+1,ans);
        return Math.max(L,R) + 1;
    }
}
