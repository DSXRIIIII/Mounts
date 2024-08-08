package cn.dsxriiiii.LeetCode.LC150;

import cn.dsxriiiii.LeetCode.LC150.structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/7 9:04
 * @Email: lihh53453@hundsun.com
 * @Description: 二叉树的层平均值
 */
public class LC637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        int size;
        queue.offer(root);
        while(!queue.isEmpty()){
            size = queue.size();
            double levelSum = 0.0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node != null){
                    levelSum += node.val;
                    if(node.left != null) queue.offer(node.left);
                    if(node.right != null) queue.offer(node.right);
                }
            }
            res.add((levelSum / size));
        }
        return res;
    }
}