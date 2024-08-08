package cn.dsxriiiii.LeetCode.LC150;

import cn.dsxriiiii.LeetCode.LC150.structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/5 16:45
 * @Email: lihh53453@hundsun.com
 * @Description:
 */
public class LC105 {
    private Map<Integer,Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        int length = inorder.length;
        for(int i = 0; i < inorder.length;i++){
            map.put(inorder[i],i);
        }
        return setTree(preorder,inorder,0,length - 1,0, length - 1);
    }

    private TreeNode setTree(int[] preorder, int[] inorder, int pre_start, int pre_end, int ino_start, int ino_end) {
        if(pre_start > pre_end) return null; //坐标相遇即停止
        int root_value = preorder[pre_start];
        int root_index_in_inorder = map.get(root_value);
        int size_left_subtree = root_index_in_inorder - ino_start;
        TreeNode root = new TreeNode(root_value);
        // 递归构建左子树
        // 左子树在前序遍历中的边界是：从pre_start + 1（根节点已使用）到pre_start + size_left_subtree
        // 左子树在中序遍历中的边界是：从ino_start到ino_end - 1（排除根节点）
        root.left = setTree(preorder, inorder, pre_start + 1, pre_start + size_left_subtree, ino_start, root_index_in_inorder - 1);
        // 递归构建右子树
        // 右子树在前序遍历中的边界是：从pre_start + size_left_subtree + 1到pre_end
        // 右子树在中序遍历中的边界是：从root_index_in_inorder + 1到ino_end
        root.right = setTree(preorder, inorder, pre_start + size_left_subtree + 1, pre_end, root_index_in_inorder + 1, ino_end);
        return root;
    }
}
