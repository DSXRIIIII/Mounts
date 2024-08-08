package cn.dsxriiiii.LeetCode.LC150;

import cn.dsxriiiii.LeetCode.LC150.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/6 10:46
 * @Email: lihh53453@hundsun.com
 * @Description: 使用中序遍历构建二叉搜索树
 */
public class LC173 {
    private List<Integer> list;
    private int index;
    public LC173(TreeNode root) {
        index = 0;
        list = new ArrayList<>();
        init_tree(root,list);
    }

    public int next() {
        return list.get(index++);
    }

    public boolean hasNext() {
        return index < list.size();
    }
    public void init_tree(TreeNode root,List<Integer> arr){
        if(root == null){
            return;
        }
        init_tree(root.left,arr);
        arr.add(root.val);
        init_tree(root.right,arr);
    }
}
