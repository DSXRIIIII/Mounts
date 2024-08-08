package cn.dsxriiiii.LeetCode.LC150;

import cn.dsxriiiii.LeetCode.LC150.structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/6 17:33
 * @Email: lihh53453@hundsun.com
 * @Description: 二叉树的右视图
 */
public class LC199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
//                queue.offer(root.left);
//                queue.offer(root.right);
                //这里要注意判断是否非空
                if(node!=null){
                    if(node.left != null) queue.offer(node.left);
                    if(node.right != null) queue.offer(node.right);
                    if(i == count - 1) res.add(node.val); //唯一的操作就是在bfs的过程中将最后的节点加入list
                }
            }
        }
        return res;
    }
}
