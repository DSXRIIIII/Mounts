package cn.dsxriiiii.LeetCode.LC150;

import cn.dsxriiiii.LeetCode.LC150.structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/5 10:21
 * @Email: lihh53453@hundsun.com
 * @Description: 相同的树
 */
public class LC100 {
    public boolean isSameTree_dfs(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }else if(p == null || q == null){
            return false;
        } else if (p.val != q.val) {
            return false;
        }else{
            return isSameTree_dfs(p.left,q.left) && isSameTree_dfs(p.right,q.right);
        }
    }

    public boolean isSameTree_bfs(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);
        while(!queue.isEmpty()){
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if(node1 == null && node2 == null){
                continue;
            }else if(node1 == null || node2 == null || node1.val != node2.val){
                return false;
            }
            queue.offer(node1.left);
            queue.offer(node2.left);
            queue.offer(node1.right);
            queue.offer(node2.right);
        }
        return true;
    }

}
