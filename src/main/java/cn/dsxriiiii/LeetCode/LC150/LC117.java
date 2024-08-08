package cn.dsxriiiii.LeetCode.LC150;

import cn.dsxriiiii.LeetCode.LC150.structure.TreeNodePoint;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/5 19:02
 * @Email: lihh53453@hundsun.com
 * @Description:
 * 使用dfs递归的方式处理
 * 1.在遍历的过程中 左节点的个数与层数都相同
 * 2.当不同时则是需要被连接的节点
 * 3.更新每一层的最新的位置节点位置
 * 4.递归处理
 * 5.递归结束 当节点为空时不处理 直接return
 */
public class LC117 {
    private final List<TreeNodePoint> list = new ArrayList<>();
    public TreeNodePoint connect(TreeNodePoint root) {
        dfs(root,0);
        return root;
    }
    public void dfs(TreeNodePoint root,int depth){
        if(root == null) return;
        if(depth == list.size()){
            list.add(root);
        }else{
            list.get(depth).next = root;
            list.set(depth,root);
        }
        dfs(root.left,depth + 1);
        dfs(root.right,depth + 1);
    }
}
