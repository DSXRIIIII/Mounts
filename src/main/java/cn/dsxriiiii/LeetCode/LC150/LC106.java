package cn.dsxriiiii.LeetCode.LC150;

import cn.dsxriiiii.LeetCode.LC150.structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/5 17:18
 * @Email: lihh53453@hundsun.com
 * @Description:
 */
public class LC106 {
    private Map<Integer,Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        int n = inorder.length;
        for(int i = 0; i < inorder.length;i++){
            map.put(inorder[i],i);
        }
        return setTree(inorder,postorder,0,n - 1,0,n - 1);
    }

    private TreeNode setTree(int[] inorder, int[] postorder, int ino_start, int ino_end, int post_start, int post_end) {
        if(ino_start > ino_end) return null;
        int root_index = map.get(postorder[post_end]);
        int left_tree_len = root_index - ino_start;
        TreeNode root = new TreeNode(postorder[post_end]);
        // 递归构建左子树。
        // 左子树在中序遍历中的边界是从ino_start到ino_start + left_tree_len - 1。
        // 左子树在后序遍历中的边界是从post_start到post_start + left_tree_len - 1。
        root.left = setTree(inorder, postorder, ino_start, root_index - 1, post_start, post_start + left_tree_len - 1);

        // 递归构建右子树。
        // 右子树在中序遍历中的边界是从root_index + 1到ino_end。
        // 右子树在后序遍历中的边界是从post_start + left_tree_len到post_end - 1。
        root.right = setTree(inorder, postorder, root_index + 1, ino_end, post_start + left_tree_len, post_end - 1);
        return root;
    }
}
