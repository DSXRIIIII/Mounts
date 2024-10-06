package cn.dsxriiiii.LeetCode.LC100;

import java.util.HashMap;
import java.util.Map;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.LC100
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/03 11:09
 * @Description:
 **/
public class LC105 {
    private Map<Integer,Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length;i++) {
            map.put(inorder[i],i);
        }
        return build(preorder,inorder,0,preorder.length - 1,0,inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int[] inorder, int p_s, int p_e, int i_s, int i_e) {
        if(p_s > p_e){
            return null;
        }
        int root_value = preorder[p_s];
        int root_index = map.get(inorder[root_value]);
        int left_tree_len = root_index - i_s;
        TreeNode root = new TreeNode(root_value);
        root.left = build(preorder,inorder,p_s + 1,p_s + left_tree_len,i_s,root_index - 1);
        root.right = build(preorder,inorder,p_s+left_tree_len + 1,p_e,root_index + 1,i_e);
        return root;
    }
}
