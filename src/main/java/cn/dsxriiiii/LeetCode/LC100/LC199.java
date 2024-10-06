package cn.dsxriiiii.LeetCode.LC100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.LC100
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/02 16:17
 * @Description:
 **/
public class LC199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node != null){
                    queue.offer(node.left);
                    queue.offer(node.right);
                    if(i == size - 1){
                        res.add(node.val);
                    }
                }
            }
        }
        return res;
    }
}
